Feature: Train Booked Test

  @wip
  Scenario Outline: Finding "<Bugs>" with invalid inputs

    Given User navigate to "https://rozklad-pkp.pl/en" webpage
    Given User should be able to accept webpage message
    When  User input data "<from>" box departure destination
    Then  User input data "<via>" box connection place
    And   User input data "<stayTime>" box connection time
    When  User input data "<to>" box arrival destination
    When  User input data "<date>" box which date will be travelled
    Given User input data "<time>" box which time will be travelled
    And   User can click search connection button
    And   Verify that user can not move next page, title should not changed
    Examples:
      | Bugs  | from   | via            | to     | stayTime | date | time  |
      | Bug01 | Berlin | Warsaw Airport | Krakow | 00:15    | 28   | 12:00 |
      | Bug02 | Krakow | Hamburg Hbf    | Berlin | 00:00    | 25   | 10:00 |
      | Bug03 | Poznan | Katowice       | Torun  | 00:01    | 3    | 14:00 |











