def solution(n, m, section):
    answer = 0
    left = 0
    
    while (True):
        if left < section[0]:
            left = section.pop(0) + m - 1
            answer += 1
        else:
            section.pop(0)
            
        if len(section) == 0: break
    
    return answer
