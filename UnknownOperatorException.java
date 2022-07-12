public class UnknownOperatorException extends Exception
{
    public UnknownOperatorException(char operator)
    {
        super(operator + " is an unknown operator. Please re-enter your last line and try again with a valid operator.");
    }
}