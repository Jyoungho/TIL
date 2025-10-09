def solution(data):
    weather_map = {
        1: 20,
        2: 20,
        3: 17, 
        4: 10,
    }
    rain_map = {
        0: 0, 
        1: 5,
        2: 14,
    }
    priority = [5, 4, 6, 2, 3, 1, 0]
    total_scores = []
    
    for day in data:
        sky, rain, temp = day

        temp_score = 20 - abs(22 - temp)
        weather_score = weather_map.get(sky, 0)
        rain_score = rain_map.get(rain, 0)

        total = temp_score + weather_score if rain == 0 else temp_score + rain_score
        total_scores.append(total)

    # 가장 소개팅 하기 좋은 날
    best_day = max(range(7), key=lambda i: (total_scores[i], -priority.index(i)))

    bad_days = [i for i, day in enumerate(data) if is_bad_day(day)]
    min_score = min(total_scores)
    min_days = [i for i, score in enumerate(total_scores) if score == min_score]
    bad_candidates = [i for i in min_days if i in bad_days]
    
    # 가장 소개팅을 하면 안되는 날
    worst_day = -1
    if bad_candidates:
        worst_day = max(bad_candidates, key=lambda i: priority.index(i))

    return [best_day, worst_day]

def is_bad_day(day):
        sky, rain, temp = day
        return sky == 4 or rain == 1 or temp >= 30 or temp <= 0


