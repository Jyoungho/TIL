def solution(C, F, X):
    base_speed = 2.0
    min_time = X / base_speed
    
    current_speed = base_speed
    total_time = 0.0
    
    while True:
        hire_time = C / current_speed
        new_speed = current_speed + F
        new_total_time = total_time + hire_time + X / new_speed
        
        if new_total_time < min_time:
            min_time = new_total_time
            total_time += hire_time
            current_speed = new_speed
        else:
            break
    
    return min_time