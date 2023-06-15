def solution(wallpaper):
    file_row_list = list()
    file_col_list = list()
    
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == '#':
                file_row_list.append(i)
                file_col_list.append(j)
                
    lux = min(file_row_list)
    luy = min(file_col_list)
    rdx = max(file_row_list) + 1
    rdy = max(file_col_list) + 1
    
    answer = [lux, luy, rdx, rdy]
    return answer
