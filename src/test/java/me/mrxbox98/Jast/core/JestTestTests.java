package me.mrxbox98.Jast.core;

import static me.mrxbox98.Jast.jest.Jest.*;

public class JestTestTests {

    public static void main(String[] args) {
        describe("Jest", () -> test("two plus two is four", () -> expect(2 + 2).toBe(4)));

    }

}
