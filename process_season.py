
from ohmysportsfeedspy import MySportsFeeds
import os

msf = MySportsFeeds(version="2.0")
    
msf.authenticate(os.getenv('MySportsFeedsAPI')), 'MYSPORTSFEEDS')
schedule = msf.msf_get_data(league='nba',season='2016-2017-regular',feed='seasonal_games',format='json', force=True)     
games = schedule['games']
refs = schedule['references']
teams = refs['teamReferences']
game0 = games[0]

plays0 = msf.msf_get_data(league='nba',season='2016-2017-regular',game='20161025-NYK-CLE',feed='game_playbyplay',format='json', force=True)     
plays_refs = plays0['references']   
players = plays_refs['playerReferences']
play_by_play = plays0[]
