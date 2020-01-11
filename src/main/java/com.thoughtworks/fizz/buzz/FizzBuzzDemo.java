package com.thoughtworks.fizz.buzz;

public class FizzBuzzDemo {

    public static void main(String[] args) {

        FizzBuzzDemo fizzBuzzMain = new FizzBuzzDemo();

        for (int i = 0; i < 120; i++) {
            String result = fizzBuzzMain.fizzBuzz(i + 1);
            System.out.println(result);
        }
    }


    public String fizzBuzz(int number) {

        FizzBuzzContext fizzBuzzContext = new FizzBuzzContext(FizzBuzzState.START_FIZZ_STATE,
                number, "");
        while (fizzBuzzContext.getState().process(fizzBuzzContext)) ;
        return fizzBuzzContext.getResult();

    }

    private enum FizzBuzzState implements State {



        START_FIZZ_STATE {
            public boolean process(FizzBuzzContext context) {
                if (context.getNumber() % 3 == 0) {
                    context.processResult(FIZZ);
                }
                context.setState(BUZZ_STATE);
                return true;
            }
        },

        BUZZ_STATE {
            public boolean process(FizzBuzzContext context) {
                int number = context.getNumber();
                if (number % 5 == 0 && !String.valueOf(number).contains("7")) {
                    context.processResult(BUZZ);
                }
                context.setState(WHIZZ_STATE);
                return true;
            }
        },

        WHIZZ_STATE {
            public boolean process(FizzBuzzContext context) {
                context.setState(CONTAIN_FIVE_NOT_SEVEN_STATE);
                int number = context.getNumber();
                if (number % 7 == 0) {
                    context.processResult(WHIZZ);
                }
                return true;
            }
        },

        CONTAIN_FIVE_NOT_SEVEN_STATE {
            public boolean process(FizzBuzzContext context) {

                String numberStr = String.valueOf(context.getNumber());
                if (numberStr.contains("5") && !numberStr.contains("7")) {
                    String result = context.getResult();
                    if (result.contains(FIZZ)) {
                        context.setResult(result.replaceAll(FIZZ, ""));
                    } else if (!result.contains(BUZZ)) {
                        context.processResult(BUZZ);
                    }
                    context.setState(END);
                    return false;
                }else {
                    context.setState(CONTAIN_THREE_STATE);
                    return true;
                }
            }
        },

        CONTAIN_THREE_STATE {
            public boolean process(FizzBuzzContext context) {
                String numberStr = String.valueOf(context.getNumber());
                if (numberStr.contains("3")) {
                    if (context.getResult().length() > 0) {
                        context.setResult("");
                    }
                    context.processResult(FIZZ);
                }
                context.setState(END);
                return false;
            }
        },

        END {
            public boolean process(FizzBuzzContext context) {
                context.setState(null);
                String result = context.getResult();
                context.setResult(result.isEmpty() ? String.valueOf(context.number) : result);
                return false;
            }
        };


        @Override
        public abstract boolean process(FizzBuzzContext context);
    }

    private interface State {

        static final String WHIZZ = "Whizz";
        static final String BUZZ = "Buzz";
        static final String FIZZ = "Fizz";

        boolean process(FizzBuzzContext context);
    }


    private class FizzBuzzContext {

        private State state;

        private int number;

        private String result;

        public FizzBuzzContext(State state, int number, String result) {
            this.state = state;
            this.number = number;
            this.result = result;
        }


        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }

        public int getNumber() {
            return number;
        }

        public String getResult() {
            return this.result.isEmpty() ? String.valueOf(this.number) : this.result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public void processResult(String newResult) {
            this.result += newResult;
        }
    }




}


