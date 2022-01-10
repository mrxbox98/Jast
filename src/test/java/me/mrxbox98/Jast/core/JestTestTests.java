package me.mrxbox98.Jast.core;

import static me.mrxbox98.Jast.jest.Jest.*;

public class JestTestTests {

    public static void main(String[] args) {
        describe("Jest", (b) -> {
            test("two plus two is four", (a) -> expect(2 + 2).toBe(4));
        });
    }

}
