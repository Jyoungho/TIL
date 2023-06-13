def solution(players, callings):
    player_rank_dict = {player:rank for rank, player in enumerate(players)}
    rank_player_dict = {rank:player for rank, player in enumerate(players)}
    
    for faster in callings:
        rank = player_rank_dict[faster]
        slower = rank_player_dict[rank - 1]
        
        rank_player_dict[rank - 1], rank_player_dict[rank] = faster, slower
        player_rank_dict[faster], player_rank_dict[slower] = rank - 1, rank
    
    return list(rank_player_dict.values())

