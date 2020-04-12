from ohmysportsfeedspy import MySportsFeeds
import os
from datetime import date, timedelta

def date_list(startdate, enddate):
    '''
    Returns a list of urls that will be scraped
    :param startdate:
    :param enddate:
    :return:
    '''
    delta = enddate - startdate  # as timedelta
    days = []
    for i in range(delta.days + 1):
        day = startdate + timedelta(days=i)
        days.append((day.year, day.month, day.day))
    return days


msf = MySportsFeeds(version="2.0")

msf.authenticate(os.getenv('MySportsFeedsAPI'), 'MYSPORTSFEEDS')
schedule = msf.msf_get_data(league='nba', season='2016-2017-regular', feed='seasonal_games', format='json',
                            force=True)

games = schedule['games']
refs = schedule['references']
teams = refs['teamReferences']
firstgame = games[0]
firstday = firstgame['schedule']['startTime'][:10]
y = firstday[:4]
m = firstday[5:7]
d = firstday[8:10]
firstdaystring = '{}{}{}'.format(firstday[:4],firstday[5:7],firstday[8:10])

lastgame = games[-1]
lastday= lastgame['schedule']['startTime'][:10]
lastdaystring = '{}{}{}'.format(lastday[:4],lastday[5:7],lastday[8:10])

y1 = int(lastday[:4])
m1 = int(lastday[5:7])
d1 = int(lastday[8:10])
url = 'https://api.mysportsfeeds.com/v2.1/pull/nba/2016-2017-regular/date/{}/games'.format(firstdaystring)
game_on_first_day = msf.msf_get_data(league='nba', season='2016-2017-regular', feed='seasonal_games',date=firstdaystring, format='json',force=True)

schedule = msf.msf_get_data(league='nba', season='2016-2017-regular', feed='daily_games', format='json',force=True)

def format_date_string(day):
    year = int(lastday[:4])
    month = int(lastday[5:7])
    day = int(lastday[8:10])
    return '{}{}{}'.format(year,month,day)


d1 = int(lastday[8:10])
def get_days_games(date_string, year = '2016-2017-regular'):
    return msf.msf_get_data(league='nba', season='2016-2017-regular', feed='daily_games', date=firstdaystring, format = 'json', force = True)


    game_on_first_day = msf.msf_get_data(league='nba', season='2016-2017-regular', feed='seasonal_games',date=firstdaystring, format='json',force=True)
game_on_first_day['games']

start_date = date(int(y),int(m),int(d))
end_date = date(int(y1),int(m1),int(d1))


dates = date_list(start_date, end_date)


