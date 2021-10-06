# language: en
@PlayList
Feature: Using Spotify

  @smoke
  Scenario: Get a User's Profile

    When user is getting a User's Profile
    Then user is checking User's information

  Scenario: Create new PlayList

    When user is creating new PlayList
    And get PlayList ID
    Then playList is created

  Scenario: Add songs to PlayList

    When user is adding  to PlayList songs
      | spotify:track:3Zvo4oKr1SRCIgfmHAuQlA |
      | spotify:track:4wowwlvO7hJpWlDBXj14Bg |
      | spotify:track:1z9MKbbqDIUGn1zhJTqBnA |

    And get List of Song from PlayList
    Then user is checking List of Song
      | Хочешь?            |
      | пммл - Live        |
      | Знак бесконечность |

  Scenario: Follow a PlayList

    When user is following a PlayList
      | 1z1i1gzN6vNJxBi2JMMgSj |
    And get List of PlayLists
    Then user is finding PlayList from List
      | Плейлист для бега от TIMERMAN. Part 2 |

  Scenario: Change a Playlist's Details

    When user is Change a Playlist's Name
      | Updated Playlist Name |
    And get List of PlayLists
    Then user is finding PlayList from List
      | Updated Playlist Name |

  Scenario: Unfollow a  Playlist

    When user is Unfollowing a  Playlist
      | 1z1i1gzN6vNJxBi2JMMgSj |
    And get List of PlayLists
    Then user is checking of removing a  Playlist
      | Плейлист для бега от TIMERMAN. Part 2 |
