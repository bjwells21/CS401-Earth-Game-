# CS401-Earth-Game-
Contributors: <br/>
Rohan Bierneni (rbierneni@horizon.csueastbay.edu) <br />
Jose Carranza (jcarranza15@horizon.csueastbay.edu) <br />
Tyler Danh (tdanh@horizon.csueastbay.edu) <br />
Billy Wells (bwells17@horizon.csueastbay.edu) <br />

current prototype of the game exists on the view class. 

current features: <br />
Deck class <br />
cards (climate, terrain and island currently) <br />
player class <br />
and the view class <br />

How to use Player Class: <br />
Player (number of initial soil, player number position) <br />
Components: <br />
* hand, which is an arrayList of Card objects <br />
* compost, which keeps track of player's compost pile<br />
* faunaObj, which detects how many fauna objectives the player has completed <br />
* totalVPoints, which keeps track of player's total VPoints <br />
* soil, which keeps track of player's soil <br />
* playerNumber, which keeps track of their player position in the player cycle <br />
* finishFirst, detects if player finished board first <br />
<br />
Functions: <br />
* addCompost(numCompost), adds to player's total compost
* getCompost(), gets player's compost
* same for getPoints() and addPoints(numPoints)
* same for getSoil() and addSoil
* useSoil(numSoil), subtracts soil
* addToHand(numberOfCards), adds cards to player's hand
* toString, prints player info

