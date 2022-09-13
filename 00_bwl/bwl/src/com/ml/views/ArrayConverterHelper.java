package com.ml.views;


//hier die implementierung fuer die Integer array Objekte 
public class ArrayConverterHelper 
{ 
public static ArrayConverter createIntegerArrayConverter() 
{ 
return new ArrayConverter() 
{ 
/* (non-Javadoc) 
* @see stuff.ArrayConverter#toObject(java.lang.Object[]) 
*/ 
public Object toObject(Object[] i_objects) 
{ 
int[] val = new int[i_objects.length]; 
for(int i = 0; i < val.length; ++i) 
{ 
val[i] = ((Integer)i_objects[i]).intValue(); 
} 
return val; 
} 

/* (non-Javadoc) 
* @see stuff.ArrayConverter#toArray(java.lang.Object) 
*/ 
public Object[] toArray(Object i_object) 
{ 
int[] v = (int[])i_object; 
Integer[] val = new Integer[v.length]; 
for(int i = 0; i < val.length; ++i) 
{ 
val[i] = new Integer(v[i]); 
} 
return val; 
} 
}; 
} 
} 
