package com.risk.model.strategies;

import java.util.ArrayList;
import java.util.Collections;

import com.risk.helper.Common;
import com.risk.helper.IOHelper;
import com.risk.model.Country;
import com.risk.model.Game;
import com.risk.model.Player;

/**
 * A cheater computer player strategy whose reinforce() method doubles the
*number of armies on all its countries, whose attack() method automatically
*conquers all the neighbors of all its countries, and whose fortify() method
*doubles the number of armies on its countries that have neighbors that belong to
*other players. 
 * 
 * @author binay
 * @version 1.0.0
 * @since 19-November-2018
 */
public class Cheater implements PlayerStrategy {

	@Override
	public boolean reinforce(Player player) {
		// TODO Auto-generated method stub
	    for (Country country:player.getAssignedCountryList())
	    { IOHelper.print("Adding reinforcement army in " + country.getCountryName());
		  player.decreaseReinforcementArmyCount();
		  country.increaseArmyCount(1);
	    }
		return true;	
}

	@Override
	public void attack(Player attackerPlayer) {
		// TODO Auto-generated method stub		
		int armies;
		Player defenderPlayer;
		for (Country country:attackerPlayer.getAssignedCountryList())
		 { for(Country neighbourCountry : country.getNeighbourCountries())
			 {  armies = neighbourCountry.getnoOfArmies();
 	            neighbourCountry.decreaseArmyCount(armies);   	
                defenderPlayer = Game.getPlayerFromID(neighbourCountry.getPlayerId());
                attackerPlayer.conquerCountry(defenderPlayer);	
	    	}	    	
	    }		
	}

	@Override
	public boolean fortify(Player player) {
		// TODO Auto-generated method stub
        int armiesCount;
		for (Country country:player.getAssignedCountryList())
	    { for(Country neighbourCountry : country.getNeighbourCountries())
	    	{ if (neighbourCountry.getPlayerId()!=player.getPlayerId())
	    	  { armiesCount = country.getnoOfArmies()*2;
	    		country.increaseArmyCount(armiesCount);
	    		}
	    	}		
	    }
		return true;
	}

}
