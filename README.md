done:

    + mvn install exec:java -Dexec.mainClass=exercise.cca.data.cli.main.MainCli -Dexec.args=""

    + mvn verify -Dtest=exercise.cca.data.cli.main.MainCliTest

    + the bonus question is answered

    + I used: Mvn 3, TestNg, Spring, Mockito, Java 7, pom.xml shows exact description

    + files currency vs value and currency vs multiplier for the exchange rate compared to USD, are in spring context

    + if those files do not exist, nothing is loaded

    + if currency has the exchange rate, then displayed line include the exchange rate, other ways not, only "currency value" is displayed

    + I used spring cheduler task for data display

    + If the net amount is 0, then currency is not displayed.

    + When the user types "quit", the program exits. I did not save any data. And "quit" string in files breaks those files reading, but not end program.

    + if "quit" chosen I used System.exit, this call leads to the shut down of the entire Java virtual machine, of course.

    + if currency is invalid it is not added, error information is printed

    + if currency value is invalid it is not added, error information is printed

    + I used System.out.println not Log4J or similar

    + And other exceptions are thrown without a catch.


original description:

    ??????? Recruitment Afternoon - Coding Exercise


    Instructions

    Use Java, Maven, and ensure that it can be built from the command line with Java 7. 

    To make it easy for us to run your submission or to clarify any assumption you have made, you may wish to provide a README.

    Your submission should be production quality: this is as important as solving the problem itself.

    ??...??

    ...

    ??...??


    Problem

    Write a program that keeps a record of payments.  Initially, the application should load the following data from a file:

    USD 1000

    HKD 100

    USD -100

    RMB 2000

    HKD 200

    Once started it should read additional lines from the console. The program should output a grand total of the payments by currency once a minute, e.g.

    USD 900

    RMB 2000

    HKD 300

    Detailed Requirements

    When your program is run, a filename can be optionally specified. The format of the file will be one or more lines with Currency Code Amount like in the Sample Input above

     , where the currency may be any uppercase 3 letter code, such as USD, HKD, RMB, NZD, GBP etc. The user can then enter more lines into the console by typing a currency and amount

      and pressing enter. Once per minute, the output showing the net amounts of each currency should be displayed. If the net amount is 0, that currency should not be displayed.

      When the user types "quit", the program should exit.

    You may need to make some assumptions. For example, if the user enters invalid input, you can choose to display an error message or quit the program. 

    Optional Bonus Question

    Allow each currency to have the exchange rate compared to USD configured. When you display the output, write the USD equivalent amount next to it, for example:

    USD 900

    RMB 2000 (USD 314.60)

    HKD 300 (USD 38.62)

    Please specify in your README file if you have answered the bonus question.

