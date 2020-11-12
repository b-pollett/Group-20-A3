

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * test for downvote(). calling method when vote count is zero, when vote count is a positive number and calling method twice in a row to check the 
     * vote count decreases or not.
     */
    @Test
    public void testdownvote()
    {
        Comment c = new Comment("Author1", "Comment1", 3);
        c.downvote();
        assertEquals(-1, c.getVoteCount());
        
        c.upvote();
        c.upvote();
        c.upvote();
        c.upvote();
        c.downvote();
        assertEquals(2, c.getVoteCount());
        
        c.downvote();
        c.downvote();
        assertEquals(0, c.getVoteCount());
        
    }
    
    /**
     * test for getRating(). testing with a positive valid rating and once for an invalid rating. since there is not check for invalid rating in Comment class
     * the invalid value will be returned. hence the test will fail.
     * (note that SalesItem has a check for invalidrating and Comment class does not)
     */
   @Test
    public void testgetRating()
    {
        Comment c2 = new Comment("Author2", "Comment2", 2);
        assertEquals(2, c2.getRating());
        
        Comment c3 = new Comment("Author3", "Comment3", -1);
        assertFalse(c3.getRating() < 0 || c3.getRating() > 5);
    }
    
    
}
