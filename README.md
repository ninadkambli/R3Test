# R3Test
I have created below scenarios.
1) Verify Failed Response: In this test, an incorrect API path is provided intentionally to receive a status code of 404, confirming the failure of the API call.
2) Confirm Successful Response: Here, the correct API path is supplied to obtain a status code of 200, ensuring that the API call is successful.
3) Validate AED Price: This scenario involves a parameterized step where Currency and Price-range are passed as parameters. It allows for the validation of price ranges from the API response for any currency.
4) Verify 162 Currency Pairs: The API response is scrutinized to ensure that it contains information for all 162 currency pairs.
5) Validate JSON Schema: The response from the API endpoint "https://open.er-api.com/v6/latest/USD" is utilized to generate a JSON Schema, which is then stored in the file "usdPriceSchema.json" under the "resources/jsonSchema" folder. The schema of the response is compared against this file to validate its structure.

   All scripts can be executed in parallel.
