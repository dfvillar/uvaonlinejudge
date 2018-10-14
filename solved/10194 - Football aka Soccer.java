import java.io.*;
import java.util.*;

/*
 * 10194 Football (aka Soccer)
 */


public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
		
		int cases = Integer.parseInt(br.readLine());

		while(cases-- > 0){
			String tournament = br.readLine();
			int participants = Integer.parseInt(br.readLine());

			HashMap<String, Team> mapTeams = new HashMap<String, Team>();
			

			while(participants-- > 0){
				String name = br.readLine();
				Team team = new Team(name);
				mapTeams.put(name, team);		
			}
			
			int games = Integer.parseInt(br.readLine());
			while(games-- > 0){
				String line = br.readLine();

				String[] middle = line.split("@");
				String[] partA = middle[0].split("#");
				String[] partB = middle[1].split("#");

				Team t1 = mapTeams.get(partA[0]);
				int a = Integer.parseInt(partA[1]);
				t1.goals += a;
				t1.games += 1;
				
				Team t2 = mapTeams.get(partB[1]);
				int b = Integer.parseInt(partB[0]);
				t2.goals += b;
				t2.games += 1;
				
				t1.against += b;
				t2.against += a;

				if(a > b){
					t1.points += 3;
					t1.wins += 1;
					t2.losses += 1;
				}else if (a < b){
					t2.points += 3;
					t2.wins += 1;
					t1.losses += 1;
				}else if (b == a){
					t1.points += 1;
					t1.ties += 1;
					t2.points += 1;
					t2.ties += 1;
				}				
			}
			List<Team> listTeams = new ArrayList<Team>();
			TeamCompare teamCompare = new TeamCompare();


			for(Map.Entry<String, Team> pair : mapTeams.entrySet()){
				listTeams.add(pair.getValue());
			}
			PrintStream out = null;
			try {
				out = new PrintStream(System.out, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException uee) {}				

			Collections.sort(listTeams, teamCompare);
			out.println(tournament);
			int i = 1;
			for(Team team : listTeams){
				out.print(i + ") ");
				out.println(team.name + " " + team.points + "p, " + team.games + "g (" + team.wins + "-" + team.ties + "-" + team.losses + "), " + (team.goals-team.against) + "gd (" + team.goals + "-" + team.against + ")");
				i++;
			}
			if(cases != 0)
			out.println();
			out.flush();
		}
	}

	private static class TeamCompare implements Comparator<Team>{

		public int compare(Team a, Team b){
			
			if(b.points != a.points){
				return b.points - a.points;
			}else if(b.wins != a.wins){
				return b.wins - a.wins;
			}else if((b.goals - b.against) != (a.goals - a.against)){
				return(b.goals - b.against) - (a.goals - a.against);
			}else if(b.goals  != a.goals){
				return b.goals - a.goals;
			}else if(b.games != a.games){
				return a.games - b.games;
			}else {
				return a.name.compareToIgnoreCase(b.name); 
			}
		}

	}

	private static class Team{
		String name;
		int points;
		int games;
		int wins;
		int ties;
		int losses;
		int goals;
		int against;

		Team(String n){
			name = n;
		}
	}
}
