# Wordle Backend

## API

### GET
/v1/wordle/stats/: load everything and kill the server<br>
/v1/wordle/stats/{identifier}: load stats of a user with the given identifier

### PUT
/v1/wordle/stats/: store a game
payload:
{
    "identifier": "xxx"
    "numberOfTries": 1-6
}