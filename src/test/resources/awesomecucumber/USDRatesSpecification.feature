Feature: USD Rates Specification




  Scenario: Validate Response is failed.
    Given USD Rates API is running.
    When Send "Invalid" USD Rates request to a server.
    Then Validate response status code should be unsuccessful.

  Scenario: Validate Response is passed.
    Given USD Rates API is running.
    When Send "valid" USD Rates request to a server.
    Then Validate response status code should be successful.

  Scenario: Validate AED Price.
    Given USD Rates API is running.
    When Send "valid" USD Rates request to a server.
    Then Validate "AED" prince between "3.6-3.7".

  Scenario: Validate total 162 currency pairs in the response.
    Given USD Rates API is running.
    When Send "valid" USD Rates request to a server.
    Then Validate 162 currency pairs.


  Scenario: Validate USD Prices JSON schema.
    Given USD Rates API is running.
    When Send "valid" USD Rates request to a server.
    Then Validate usdPriceSchema








