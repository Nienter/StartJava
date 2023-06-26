package com.myjava.javatest;

public enum SeasonSum implements SeasonInter {
    Spring("chuan") {
        @Override
        public void des() {

        }
    }, Summer("xua") {
        @Override
        public void des() {

        }
    }, Fall("qiu") {
        @Override
        public void des() {

        }
    }, Winner("dong") {
        @Override
        public void des() {

        }
    };
    private final String name;

    private SeasonSum(String chuan) {
        this.name = chuan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        switch (this) {
            case Winner:
        }
    }


}
