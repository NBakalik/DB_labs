# DB_labs

### Saved procedures

1. Ensure parameterized insertion of new values in the Employees table.
2. Ensure the M: M link between the Drug List and Zone of Influence tables, ie insert the appropriate tape in the
   docking table, with the relevant tapes in the main tables.
3. Using the cursor, ensure the dynamic creation of tables with the names of employees in the current database, with a
   random number of columns (from 1 to 9). Column names and types are arbitrary.

### Custom functions

1. For the Employees table, write the function that will return MIN Experience column. Then select the data using this
   function.
2. Write a function that extracts the combined value of the Name and Home fields between the Employees and Pharmacy
   tables. Then select the data from the Employees table using this function

### Triggers

1. Ensure the integrity of the values for the database structure
2. Employees → Identification number can not end with two zeros;
3. For the List of Medicines → Code of the Ministry, provide the format input: 2 letters, except M and P + '-' + 3
   digits + '-' + 2 digits.
4. Prohibit any modification of the data in the Position table