Feature: Search functionality

  Scenario Outline: User gets expected data after filtering out by first registration and sorting by price
    When user opens page <page>
    And Sets <value> for <filter> filter
    And Ensure filter <filter> is applied
    And Sorts results by <parameter>
    And Gets found results
    Then Search results are filtered by <filter> <value>
    And results are sorted by <parameter>
    Examples:
    |page                                   |filter         |value   |parameter     |
    |"https://www.autohero.com/de/search/"  |"Erstzulassung"|"2015"  |"Höchster Preis"|