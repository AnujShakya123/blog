package com.example.blog.Services;

import com.example.blog.Repositories.BlogRepository;
import com.example.blog.Repositories.ImageRepository;
import com.example.blog.models.Blog;
import com.example.blog.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ImageService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private ImageRepository imageRepository;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image = new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);

        Blog blog = blogRepository.findById(blogId).get();
        image.setBlog(blog);

        // add list to blog
        blog.getImageList().add(image);
//        List<Image> imageList = blog.getImageList();
//        imageList.add(image);

        blogRepository.save(blog);
        return image;
    }

    public void deleteImage(Integer id){
        imageRepository.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

        //4X4 = 4/2*4/2 == 2*2== 4 images
        Image image = imageRepository.findById(id).get();

        String imageDimensions = image.getDimensions();
        //image dimension is in String format ex: 2X2
        //we have to convert it into integer like 2*2=4
        //below is the process to calculate image dimension as width and height

        int indexOfX = imageDimensions.indexOf('X');

        String x = imageDimensions.substring(0,indexOfX);
        String y = imageDimensions.substring(indexOfX+1);

        int imageWidth = Integer.parseInt(x);
        int imageHeight= Integer.parseInt(y);


        //Like above, Similarly find screen dimension in integer format

        int screenIndexOfX = screenDimensions.indexOf('X');

        String screenX = screenDimensions.substring(0,screenIndexOfX);
        String screenY = screenDimensions.substring(screenIndexOfX+1);

        int screenWidth = Integer.parseInt(screenX);
        int screenHeight = Integer.parseInt(screenY);

        //THIS COMMENTED LOGIC IS NOT WORKING DON'T KNOW WHY. ASK IN DOUBT
        // int totalImageDimension = imageWidth * imageHeight;
        // int totalScreenDimension = screenWidth * screenHeight;
        // int count = totalScreenDimension/totalImageDimension;


        // Final count
        int count = (screenWidth/imageWidth) * (screenHeight/imageHeight);

        return count;

    }
}