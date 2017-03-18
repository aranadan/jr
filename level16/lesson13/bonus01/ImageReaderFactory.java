package com.javarush.test.level16.lesson13.bonus01;



import com.javarush.test.level16.lesson13.bonus01.common.*;




/**
 * Created by Andrey on 16.05.2016.
 */
public class ImageReaderFactory
{


    public static ImageReader getReader(ImageTypes image)
    {

        if (image == ImageTypes.BMP){
            return new BmpReader();
        }
        else if (image==ImageTypes.JPG){
            return new JpgReader();
        }
        else if (image==ImageTypes.PNG){
            return new PngReader();
            }
        else throw  new  IllegalArgumentException("Неизвестный тип картинки");



    }

}
