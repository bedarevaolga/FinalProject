# language: en
@PlayList
Feature: Using Spotify

  Scenario: Get a User's Profile
   # When a user is logged in Spotify
    And user is getting a User's Profile
    Then user is checking User's information


  Scenario: Create new PlayList

   # When a user is logged in Spotify
    And user is creating new PlayList
    And get PlayList ID
    Then playList is created

  Scenario: Add songs to PlayList

    #When a user is logged in Spotify
    And user is adding  to PlayList songs
      | spotify:track:3Zvo4oKr1SRCIgfmHAuQlA |
      | spotify:track:4wowwlvO7hJpWlDBXj14Bg |
      | spotify:track:1z9MKbbqDIUGn1zhJTqBnA |

    And get List of Song from PlayList
    Then user is checking List of Song
      | Хочешь?            |
      | пммл - Live        |
      | Знак бесконечность |

  Scenario: Change a Playlist's Details

    #When a user is logged in Spotify
    And user is Change a Playlist's Name
#    |Updated Playlist Name|
#    Then user is checking List of Song
#      | Хочешь? |
#      | пммл - Live |
#      | Знак бесконечность |