def solution(park, routes):
    start_point = [0, 0]
    
    for i in range(len(park)):
        for j in range(len(park[i])):
            if park[i][j] == "S":
                start_point = [i, j]
                
        
    now_point = start_point
    for route in routes:
        (move_x, move_y) = convertRouteToCoordinate(route)
        
        
        (row, col) = move(now_point, park, move_y, move_x) if move(now_point, park, move_y, move_x) else (-1, -1)
        
        if (row, col) == (-1, -1):
            continue
            
        now_point = row, col
            
    return list(now_point)

def convertRouteToCoordinate(route):
    direction = route[0]
    distance = int(route[2])
    move_x = 0
    move_y = 0
    if direction == 'E':
        move_x = distance
    elif direction == 'W':
        move_x = -distance
    elif direction == 'S':
        move_y = distance
    elif direction == 'N':
        move_y = -distance
    
    return (move_x, move_y)

def move(now_point, park, move_y, move_x):
    (row, col) = now_point
    
    if move_x != 0:
        max_col_len = len(park[row])
        
        if move_x > 0:
            direction = 1
        if move_x < 0:
            direction = -1
            
        while (True):
            col = col + direction
            if col >= max_col_len or col < 0:
                break
            if park[row][col] == 'X':
                break
            
            move_x += -direction
            if move_x == 0:
                return (row, col)
    
    if move_y != 0:
        max_row_len = len(park)
        
        if move_y > 0:
            direction = 1
        if move_y < 0:
            direction = -1
            
        while (True):
            row = row + direction
            if row >= max_row_len or row < 0:
                break
            if park[row][col] == 'X':
                break
            
            move_y += -direction
            if move_y == 0:
                return (row, col)
            
        
