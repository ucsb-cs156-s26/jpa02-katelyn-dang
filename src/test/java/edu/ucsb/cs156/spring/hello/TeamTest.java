package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
	assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void testEquals() {
	assertTrue(team.equals(team));

	assertFalse(team.equals(null));
	assertFalse(team.equals("not team"));

	Team same = new Team("test-team");
	Team diffName = new Team("other-team");
	Team sameNameDiffMem = new Team ("test-team");
	sameNameDiffMem.getMembers().add("Chris");

	assertTrue(team.equals(same));
	assertFalse(team.equals(sameNameDiffMem));
	assertFalse(team.equals(diffName));
	diffName.getMembers().add("Chris");
	assertFalse(team.equals(diffName));
    }
    
    @Test
    public void hashCode_equal() {
	Team t1 = new Team("test team");
	Team t2 = new Team ("test team");
	assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_specificVal() {
	Team t = new Team("test team");
	int result = t.hashCode();
	assertEquals(-1238304469, result);
    }  
}
