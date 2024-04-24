# R3Test

I have created below 4 scenarios 
1)  Validate Resonse is failed.
    In this test I am passing wrong API path to get status code 404. I validated API is failed.
2)  Validate Response is passed.
    Here I have passed the correct API path to get status code 200 and check API is passed.
3)  Validate AED Price.
    I have written a parameterized step where I passsed Currency and Price-range as the parameters. This step can be used to validate price range from API response for any currency.
4) Validate total 162 currency pairs.
   I have validated in API respons we should have 162 currencies.
5) Validate JSON Schema.
   I copied response of the API https://open.er-api.com/v6/latest/USD and generated JSON Schema and stored in the file usdPriceSchema.json under resounces/jsonSchema folder. Validated schema of the response against that file.

   All scripts can be executed in parallel.
