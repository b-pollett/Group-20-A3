import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
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
     * Test the number of comments when there are 0 as well when there are multiple
     */
    @Test
    public void testGetCommentNumber()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(0, salesIte1.getNumberOfComments());
        salesIte1.addComment("James Duckling", "This book is great.", 4);
        salesIte1.addComment("Joshua Black", "Not worth the money.", 1);
        assertEquals(2, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money.", -5));
    }
    
    /**
     * Test that an author posts multiple comments is rejected.
     */
    @Test
    public void testMultipleComment()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", 1);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Hated it.", 1));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }

    /**
     * Test that a sales item using an invalid price is rejected.
     */
    @Test
    public void testIllegalPrice()
    {
        SalesItem salesIte1 = new SalesItem("Java", -1000);
        assertNull(salesIte1);
    }
    
    /**
     * Tests that the comment successfully gets add to an item.
     */
    @Test
    public void addComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain Surgery for Dummies.", 9899);
        assertEquals(true, salesIte1.addComment("Fred", "Great!", 4));
    }
    
    /**
     * Test that a comment is removed.
     */
    @Test
    public void testRemoveComment()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        salesIte1.addComment("Joshua Black", "Not worth the money.", 1);
        salesIte1.addComment("Fred", "Great!", 4);
        salesIte1.removeComment(0);
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that removeComment does nothing if no comments are found.
     */
    @Test
    public void testRemoveCommentEmpty()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        salesIte1.removeComment(1);
        assertEquals(0, salesIte1.getNumberOfComments());
    }
    
    /**
     * Test that removeComment does nothing if the index is invalid.
     */
    @Test
    public void testRemoveCommentInvalid()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        salesIte1.addComment("Joshua Black", "Not worth the money.", 1);
        salesIte1.removeComment(2);
        assertEquals(1, salesIte1.getNumberOfComments());
    }   
    
    /**
     * test for findCommentByAuthor(). we'll add comments in empty list and filled list with both new authors and used authors to determine whether the
     * the method that is being used by addComment is functioning or not.
     */
    @Test
    public void testfindCommentByAuthor()
    {
        SalesItem item = new SalesItem("item 1", 00001);
        assertEquals(true, item.addComment("Author1", "Comment1", 5));
        assertEquals(1, item.getNumberOfComments());
        assertEquals(true, item.addComment("Author2", "Comment2", 4));
        assertEquals(2, item.getNumberOfComments());
        assertEquals(false, item.addComment("Author2", "Comment3", 2));
        assertEquals(2, item.getNumberOfComments());
    }
    
    /**
     * Test for priceString()  . We'll input different prices and manually debug using the print statements that if the output is correctly displayed
     */ 
    @Test
    public void testpriceString()
    {
        SalesItem item1 = new SalesItem("item1", 14394);
        item1.showInfo();
        SalesItem item2 = new SalesItem("item2", 32509);
        item2.showInfo();
        SalesItem item3 = new SalesItem("item3", -1304);
        item3.showInfo();
    }

    
    /**
    * Test that a comment is upvoted.
    */
    @Test
    public void testupvoteComment()
      {
      SalesItem salesIte1 = new SalesItem("Brain Surgery for Dummies.", 9899);
      salesIte1.upvoteComment(0);
      salesIte1.showInfo();
      }

    /**
    * Test that a comment is downvoted.
    */
    @Test
    public void testdownvoteComment()
       {
      SalesItem salesIte1 = new SalesItem("Brain Surgery for Dummies.", 9899);
      salesIte1.downvoteComment(0);
      salesIte1.showInfo();
      }

    /**
    * Test for the MostHelpfulComment
    */
    @Test
    public void testfindMostHelpfulCommentEmpty()
      {
      SalesItem salesIte1 = new SalesItem("Brain Surgery for Dummies.", 9899);
      assertEquals(false, salesIte1.findMostHelpfulComment());
      }
    
    @Test
    public void testfindMostHelpfulComment()
      {
      SalesItem salesIte1 = new SalesItem("Brain Surgery for Dummies.", 9899);
      salesIte1.addComment("author_name", "Comment", 2);
      salesIte1.addComment("author_name2", "Comment", 5);
      salesIte1.upvoteComment(1);
      assertEquals("author_name2", salesIte1.findMostHelpfulComment().getAuthor());
      }
      
      

    /**
    * Test whether the rating is valid or invalid.
    */
    @Test
    public void testratingInvalid()
      {
        SalesItem salesIte1 = new SalesItem("Brain Surgery for Dummies.", 9899);
        salesIte1.addComment("author_name","Comment",20);
        assertEquals(true, salesIte1.addComment("Joshua Black", "Not worth the money.", 3));
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money.", -5));
      }
}


