#Features
@author Yiwei

In addition to the features that are auto-graded, the graphical user interface
of our project implements the following features:

*(Remove those that are unimplemented)*

 - A simple placement viewer (Task 4)
 - A basic playable game
 - A basic playable game that snaps pieces to the board and checks for validity (Task 9)
 - Computes a score for the game (Task 8)
 - Playable against a computer opponent (Task 11)

#Additional features...
- MUSIC

- START SCENE
	- Name Human Players
	- Name AI Players
	- Choose Difficulty Level
	- Choose Variants
	- Instructions

- Basic function
	- Draw from deck
	- Highlight Nearest Square and snap
	- Show all possible location
	- Update scores

- AI player
	- Basic AI: Generate a random valid move - Task 10
	- Advanced AI: Mark all the paths and generate a best move - Task 11

- Variants
	- Allow players to hold more than one piece in their hand - Task 12

- ENLIGHTEN
	- Enlighten all the paths with a random RGB color
	
#Structure of the main class


The following structure aligns with the original order of Game.java

- Start Method
    -	public void start(Stage primaryStage) throws Exception {

- Start control

    -   private void makeStartControls() {
        
    -    private void setHumanPlayersStart() {
        
    -    private void setAiPlayersStart() {
        
    -    private void addVariants() {
        
    -    private void putextraTile() {
        
    -    private void chooseDifficulty() {

- Highlight Square    
   
    -	public Tile findNearestSquare(double x, double y) {
        
    -	public void highlightNearestSquare(double x, double y) {

- Hightlight possible locations
	
    -	public static ArrayList<String> getPossibleLocation(String placementSequence, String tileType) {
        
    -    public void highlightPossibleLocation(String placementSequence, String tileType) {

- Set the still part of the game in the main Scene        
    -	private void setVBoxLeft() {
        
    -	public void setVBoxRight() {
        
    -	private void sethBOX() {
        
    -	public void makeLightGreySquareBoard() {
        
    -	private void setBoardBackground() {
        
    -	void makeBoard() {

- General help methods
	
    -	public String getPlacementSequence() {
        
    -	private void drawATile(MouseEvent event) {  
        
    -	public int updateMarks(int numOfPlayers, int index) {

- Turn control	
    -	public void updateTurns() {
        
    -	boolean checkAiTurn() {

- AI control
    -	void placeAiTile() { < - This is for basic AI.
        
    -	public ArrayList<Integer> getAIPathStationList() {
        
    -	public ArrayList<ArrayList<Integer>> getplayerstationByNum(int numberOfPlayers) {
        
    -	String getAdvancedTilePlacement(String tiletypeAi) {
        
    -	int convertStartStationToLoc(int startStation) {
        
    -	void placeAdvancedAiTile() { < - This is for advanced AI.
	
-	void enlightPath() {
	
-	public void music() {

# Other comments

- JUnits:
    - 3 newly added Junits for test driven development in tests (suffix _new)

- Comments and authorship added

# Limitations 

- The limitation for 2 - 6 players has its root in the station to player mapping. And the player 
number must be a factor of 60 tiles to use up the tiles. By default would be at least 1 human player and 1 AI player to avoid error.
- The tile in Player hand is not refreshed automatically to avoid the last index out of boundry error. (This could be improved.)
- The enligten method colors the path from station 1 - 32 so the previous path would be replaced by new color. 

# Caution for players
- Remember to click the "set human players" and "set AI players" button to set the players. But don't double click cause it will create duplicate players and very easy to exceed the number of players limit.
- The possible location is only shown when mouse clicked. When mouse dragged the color shows the highlighted square so I can't put the highlight possible location method there.
- Once there is no possible location for the Tile, the AI will stop playing cause it doesn't have exceptions. It happens sometimes.
- If "dddd" is the first tile you get, please use another image to draw another tile cause "dddd" has no vaild location for first piece.

The game.jar should be executable from the root directory of this project both in IntelliJ and from Terminal.
For any unexpected issues or other clarifications, please do not hesitate to contact me directly. I can be reached via email or piazza.

Thanks,
Yiwei

