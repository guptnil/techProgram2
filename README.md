# techProgram2
Repository for Accounts Project

Project Name : AccountManager

Project Description : This application provides Rest back end api's to support a web application to that allows a user to view accounts and
subsequently view transactions on any of the accounts they hold .

Installation/Execution Steps : $ git clone https://github.com/guptnil/techProgram2 $ cd techProgram2 $ mvn spring-boot:run

Open the browser and run http://localhost:8080/getAccounts , This would give the list of accounts.
On running http://localhost:8080/getTransactions?accountNo=585309209 would give transactions associated with given account number.
