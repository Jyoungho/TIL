def solution(name, yearning, photo):
    answer = []
    name_yearning_dict = {name: yearning for i, (name, yearning) in enumerate(zip(name, yearning))}
    
    for row in photo:
        score = 0
        for person in row:
            score += name_yearning_dict.get(person, 0)
            
        answer.append(score)
    
    return answer
