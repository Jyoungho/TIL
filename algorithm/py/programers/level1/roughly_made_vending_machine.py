def solution(keymap, targets):
    answer = list()
    
    for target in targets:
        # 알바벳 별로 최소 누르는 횟수를 담는다.
        min_press_alpha = dict()
        sum_press_count = 0
        
        for alpha in target:
            for key in keymap:
                for i in range(len(key)):
                    if alpha == key[i]:
                        # 최소 키보드 누름 횟수를 저장한다.
                        min_press_alpha[alpha] = min(i, min_press_alpha.get(alpha, 101))
            
            # 키보드를 누를 수 없을 경우 -1를 반환한다.
            if min_press_alpha.get(alpha, -1) == -1:
                sum_press_count = min_press_alpha.get(alpha, -1)
                break
            
            # 키보드를 누를 수 있을 경우 키보드 누름 횟수를 누산한다.
            sum_press_count += min_press_alpha.get(alpha) + 1
            
        answer.append(sum_press_count)
    
    return answer
