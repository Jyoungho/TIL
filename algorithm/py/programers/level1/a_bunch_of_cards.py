def solution(cards1, cards2, goal):
    answer = 'Yes'
    for _ in range(len(goal)):
        word = goal.pop(0)
        
        if len(cards1) > 0 and cards1[0] == word:
            cards1.pop(0)
            continue
            
        if len(cards2) > 0 and cards2[0] == word:
            cards2.pop(0)
            continue
        
        answer = "No"
        break
            
    return answer
