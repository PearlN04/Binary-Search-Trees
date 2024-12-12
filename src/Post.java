public class Post implements Comparable<Post>{
  private String title;
  private String video;
  private int numLikes;
 

  /**Post function is a constructor for the post class
  *creates an instance of the Post class 
  *@param String title is the title of the post
  *@param String video is the video being uploaded
  *@param int numLikes is the number of likes of a post
  *
  */ 
  public Post(String title,String video, int numLikes){
    this.title = title;
    this.video = video;
    this.numLikes = numLikes;
  }
  
 
  /**
  *The toString function returns the title of the video,video and the number of likes the video has
  *@return title, video and the number of likes
  *
  */
  public String toString(){
    return "Title: " +title +"\n" +"Video: " +video +"\n" +"Number of likes: " +Integer.toString(numLikes);
  }
  
  
  /**
  *The getNumlikes returns the number of likes a post has
  *
  *@return number of likes a video has
  */
  public int getNumLikes(){
    return numLikes;
  }
  
  
  /**
  *The getTitle function returns the title of a post
  *
  *@return the title of the post
  */
  public String getTitle(){
   return title;
  }
  
  /**
  *The getVideo function returns the video
  *
  *@return the video
  */
  public String getVideo(){
   return video;
  }
   
 
  /**
  *this compareTo function compares the likes of one post to another
  *
  *@return 0 if they are and returns a negative number if the number of likes,
  *of this post are less than the number of likes of the other post
  */
  @Override
  public int compareTo(Post anotherPost){
    Integer numInteger = Integer.valueOf(numLikes);
    Integer anotherPostLikes = Integer.valueOf(anotherPost.getNumLikes());
    return numInteger.compareTo(anotherPostLikes);
  }
}