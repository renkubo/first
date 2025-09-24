-- 問1: 全選手の背番号・名前・所属クラブ
SELECT uniform_num, name, club
FROM players;

-- 問2: グループCの国
SELECT name
FROM countries
WHERE group_name = 'C';

-- 問3: グループC以外の国
SELECT name
FROM countries
WHERE group_name <> 'C';

-- 問4: 現時点で40歳以上の選手
SELECT *
FROM players
WHERE birth <= CURRENT_DATE - INTERVAL '40 years';

-- 問5: 身長が170cm未満の選手
SELECT *
FROM players
WHERE height < 170;

-- 問6: FIFAランクが日本(46位)の前後10位（36?56位）
SELECT name, ranking
FROM countries
WHERE ranking BETWEEN 36 AND 56;

-- 問7: ポジションがGK、DF、MF
SELECT *
FROM players
WHERE position IN ('GK', 'DF', 'MF');

-- 問8: オウンゴール
SELECT *
FROM goals
WHERE player_id IS NULL;

-- 問9: オウンゴール以外のゴール
SELECT *
FROM goals
WHERE player_id IS NOT NULL;

-- 問10: 名前の末尾が「ニョ」
SELECT *
FROM players
WHERE name LIKE '%ニョ';

-- 問11: 名前の中に「ニョ」
SELECT *
FROM players
WHERE name LIKE '%ニョ%';

-- 問12: 小柄な選手（身長165未満または体重60未満）
SELECT *
FROM players
WHERE height < 165 OR weight < 60;

-- 問13: FWかMFで170未満（ORとAND使用）
SELECT *
FROM players
WHERE (position = 'FW' OR position = 'MF') AND height < 170;

-- 問14: ポジションの一覧（重複なし）
SELECT DISTINCT position
FROM players;

-- 問15: 体力指数（身長＋体重）と選手名、所属クラブ
SELECT name, club, height + weight AS "体力指数"
FROM players;

-- 問16: 全選手を身長の大きい順、同じ身長は体重の重い順
SELECT *
FROM players
ORDER BY height DESC, weight DESC;

-- 問17: 全ゴール、オウンゴールはplayer_idを9999
SELECT id,
       COALESCE(player_id, 9999) AS player_id,
       pairing_id,
       goal_time
FROM goals;

-- 問18: 全選手の平均身長・平均体重
SELECT AVG(height) AS avg_height, AVG(weight) AS avg_weight
FROM players;

-- 問19: 日本の選手（id 714?736）が上げたゴール数
SELECT COUNT(*) AS goals
FROM goals
WHERE player_id BETWEEN 714 AND 736;

-- 問20: 最も高い身長と最も軽い体重
SELECT MAX(height) AS max_height, MIN(weight) AS min_weight
FROM players;

-- 問21: CグループのFIFAランク合計
SELECT SUM(ranking) AS sum_fifa_rank
FROM countries
WHERE group_name = 'C';

-- 問22: 全試合の国名、選手名、得点時間（オウンゴール除外）
SELECT c.name AS country_name, p.name AS player_name, g.goal_time
FROM goals g
JOIN players p ON g.player_id = p.id
JOIN countries c ON p.country_id = c.id;

-- 問23: 左外部結合でオウンゴールも表示
SELECT g.goal_time, p.name
FROM goals g
LEFT JOIN players p ON g.player_id = p.id;

-- 問24: 右外部結合でオウンゴールも表示
SELECT g.goal_time, p.name
FROM goals g
RIGHT JOIN players p ON g.player_id = p.id;

-- 問25: 全試合のゴール時間、選手名、国名（オウンゴール含む）
SELECT g.goal_time, p.name AS player_name, c.name AS country_name
FROM goals g
LEFT JOIN players p ON g.player_id = p.id
LEFT JOIN countries c ON p.country_id = c.id;

-- 問26: 副問合せでオウンゴール除外
SELECT goal_time,
       (SELECT name FROM players WHERE id = g.player_id) AS player_name
FROM goals g
WHERE player_id IS NOT NULL;

-- 問27: 各ポジションごとの最も身長の高い選手（副問合せ使用）
SELECT p.name, p.club, p.position, p.height
FROM players p
WHERE p.height = (SELECT MAX(height) 
                  FROM players 
                  WHERE position = p.position);

-- 問28: 各グループの最上位・最下位FIFAランク、その差が50以上
SELECT group_name, MAX(ranking) AS max_rank, MIN(ranking) AS min_rank
FROM countries
GROUP BY group_name
HAVING MAX(ranking) - MIN(ranking) > 50;

-- 問29: 1980年生まれと1981年生まれの人数（UNION使用、date型対応）
SELECT COUNT(*) AS num_players, '1980' AS year
FROM players
WHERE TO_CHAR(birth, 'YYYY') = '1980'

UNION

SELECT COUNT(*) AS num_players, '1981' AS year
FROM players
WHERE TO_CHAR(birth, 'YYYY') = '1981';

-- 問30: 身長195以上または体重95以上、両方該当は2件分（id昇順）
SELECT id, name, height, weight
FROM players
WHERE height > 195 OR weight > 95
ORDER BY id;

-- 問31: 身長の高い選手6位～20位（身長同順は名前昇順）
SELECT name, height, weight
FROM players
ORDER BY height DESC, name ASC
OFFSET 5 LIMIT 15;

-- 問32: グループCの各対戦毎にゴール数（外部結合のみ）
SELECT p.kickoff, 
       hc.name AS home_country, 
       ac.name AS away_country,
       hc.ranking AS home_rank,
       ac.ranking AS away_rank,
       COALESCE(g.goal_count, 0) AS home_goals
FROM pairings p
JOIN countries hc ON p.my_country_id = hc.id
JOIN countries ac ON p.enemy_country_id = ac.id
LEFT JOIN (
    SELECT pairing_id, COUNT(*) AS goal_count
    FROM goals
    WHERE player_id IS NOT NULL
    GROUP BY pairing_id
) g ON p.id = g.pairing_id
WHERE hc.group_name = 'C'
ORDER BY p.kickoff, hc.ranking;

-- 問33: グループCの各対戦毎にゴール数（副問合せ使用）
SELECT p.kickoff, 
       hc.name AS home_country, 
       ac.name AS away_country,
       hc.ranking AS home_rank,
       ac.ranking AS away_rank,
       (SELECT COUNT(*) 
        FROM goals g 
        WHERE g.pairing_id = p.id AND g.player_id IS NOT NULL) AS home_goals
FROM pairings p
JOIN countries hc ON p.my_country_id = hc.id
JOIN countries ac ON p.enemy_country_id = ac.id
WHERE hc.group_name = 'C'
ORDER BY p.kickoff, hc.ranking;
