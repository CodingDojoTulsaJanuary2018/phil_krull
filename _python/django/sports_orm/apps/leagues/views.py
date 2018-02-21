from django.shortcuts import render, redirect
from .models import League, Team, Player

from . import team_maker

def index(request):
	context = {
		# "leagues": League.objects.all(),
		# "teams": Team.objects.all(),
		# "players": Player.objects.all(),
		# 1 ...all baseball leagues
		# 'leagues': League.objects.filter(name__icontains = 'baseball')
		# 2 ...all womens' leagues
		# 'leagues': League.objects.filter(name__icontains = 'women')
		# 3 ...all leagues where sport is any type of hockey
		# 'leagues': League.objects.filter(sport__icontains='hockey')
		# 4 ...all leagues where sport is something OTHER THAN football
		# 'leagues': League.objects.exclude(sport__icontains = 'football')
		# 5 ...all leagues that call themselves "conferences"
		# 'leagues': League.objects.filter(name__icontains = 'conference')
		# 6 ...all leagues in the Atlantic region
		# 'leagues': League.objects.filter(name__icontains = 'atlantic'),
		# 7 ...all teams based in Dallas
		# 'teams': Team.objects.filter(location = 'Dallas')
		# 8 ...all teams named the Raptors
		# 'teams': Team.objects.filter(team_name = 'Raptors')
		# 9 ...all teams whose location includes "City"
		# 'teams': Team.objects.filter(location__contains = 'City')
		# 10 ...all teams whose names begin with "T"
		# 'teams': Team.objects.filter(team_name__startswith = 'T')
		# 11 ...all teams, ordered alphabetically by location
		# 'teams': Team.objects.filter(team_name__startswith = 'A') | Team.objects.filter(location__startswith = 'T')
		# 12 ...all teams, ordered by team name in reverse alphabetical order
		# 'teams': Team.objects.all().order_by('-team_name')
		# 13 ...every player with last name "Cooper"
		# 'players': Player.objects.filter(last_name = 'Cooper')
		# 14 ...every player with first name "Joshua"
		# 'players': Player.objects.filter(first_name = 'Joshua')
		# 15 ...every player with last name "Cooper" EXCEPT those with "Joshua" as the first name
		# 'players': Player.objects.filter(last_name = 'Cooper').exclude(first_name = 'Joshua')
		# 16 ...all players with first name "Alexander" OR first name "Wyatt"
		# 'players': Player.objects.filter(first_name__in = ['Alexander', 'Wyatt'])
		# 17 ...all teams in the Atlantic Soccer Conference
		'teams': Team.objects.filter(league__name = 'Atlantic Soccer Conference') | Team.objects.filter(league__name__icontains = 'Pacific' )
		# ...all (current) players on the Boston Penguins
		# ...all (current) players in the International Collegiate Baseball Conference
		# ...all (current) players in the American Conference of Amateur Football with last name "Lopez"
		# ...all football players
		# ...all teams with a (current) player named "Sophia"
		# ...all leagues with a (current) player named "Sophia"
		# ...everyone with the last name "Flores" who DOESN'T (currently) play for the Washington Roughriders
		# ...all teams, past and present, that Samuel Evans has played with
		# ...all players, past and present, with the Manitoba Tiger-Cats
		# ...all players who were formerly (but aren't currently) with the Wichita Vikings
		# ...every team that Jacob Gray played for before he joined the Oregon Colts
		# ...everyone named "Joshua" who has ever played in the Atlantic Federation of Amateur Baseball Players
		# ...all teams that have had 12 or more players, past and present. (HINT: Look up the Django annotate function.)
		# ...all players and count of teams played for, sorted by the number of teams they've played for
	} 
	return render(request, "leagues/index.html", context)

def make_data(request):
	team_maker.gen_leagues(10)
	team_maker.gen_teams(50)
	team_maker.gen_players(200)

	return redirect("index")