package com.wr.riddles.misc;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertNull;

public class LinkedTest {

    @Test
    public void testReverse() throws Exception {
        Linked.Node a = new Linked.Node("a");
        Linked.Node b = new Linked.Node("b");
        Linked.Node c = new Linked.Node("c");
        Linked.Node d = new Linked.Node("d");

        // a -> b -> c -> d
        a.next = b;
        b.next = c;
        c.next = d;

        Linked.Node res = Linked.reverse(a);

        // d -> c -> b -> a
        assertThat(res, equalTo(d));
        assertThat(d.next, equalTo(c));
        assertThat(c.next, equalTo(b));
        assertThat(b.next, equalTo(a));
        assertNull(a.next);
    }

}