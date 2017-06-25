This program displays the teams playing cricket and their respective scores in the terminal. The data is obtained from www.espncricinfo.com. Additionl information is stored in the MatchObject objects which can be accessed if needed, with slight changes to the code.

This works best with a maximized terminal.

On UNIX:
1) Go to the folder
2) Compile with 

    javac -cp .:jsoup-1.9.2.jar CricketScores.java MatchObject.java

3) Run with 

    java -cp .:$PATH_TO_FOLDER/jsoup-1.9.2.jar:$PATH_TO_FOLDER CricketScores

On Windows:
1) Go to the folder
2) Compile with 

    javac -cp .;jsoup-1.9.2.jar CricketScores.java MatchObject.java

3) Run with:

    java -cp .;$PATH_TO_FOLDER/jsoup-1.9.2.jar;$PATH_TO_FOLDER CricketScores

Linux users may be able to add a shortcut to the run command as follows:

    vim ~/.bash_aliases
    alias cricscores="java -cp.:$PATH_TO_FOLDER/jsoup-1.9.2.jar:$PATH_TO_FOLDER CricketScores
    source ~/.bash_aliases

Run with:

    cricscores

