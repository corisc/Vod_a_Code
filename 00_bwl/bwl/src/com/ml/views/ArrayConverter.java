package com.ml.views;

//hier das interface fuer die arrays 
public interface ArrayConverter 
{ 
/** 
* This method transforms an array of objects into an object. 
* 
* @param i_objects An array of objects. 
* @return An object. 
*/ 
public Object toObject(Object[] i_objects); 

/** 
* This method transforms an object into an array of objects. 
* 
* @param i_object The object to transform. 
* @return An array of objects. 
*/ 
public Object[] toArray(Object i_object); 
} 
