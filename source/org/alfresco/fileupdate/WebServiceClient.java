package org.alfresco.fileupdate;

import java.io.File;
import java.io.FileInputStream;

import org.alfresco.webservice.content.Content;
import org.alfresco.webservice.content.ContentServiceSoapBindingStub;
import org.alfresco.webservice.types.ContentFormat;
import org.alfresco.webservice.types.ParentReference;
import org.alfresco.webservice.types.Store;
import org.alfresco.webservice.util.AuthenticationUtils;
import org.alfresco.webservice.util.Constants;
import org.alfresco.webservice.util.WebServiceFactory;

public class WebServiceClient
{
    
    public static void main(String[] args) throws Exception
    {
        // Start the session
        AuthenticationUtils.startSession("admin", "admin");
        
        //File number 1
        try
        {
        	// Create a reference to the parent where we want to create content
            Store storeRef = new Store(Constants.WORKSPACE_STORE, "SpacesStore");
            ParentReference parent = new ParentReference(storeRef, null, "/app:company_home/cm:test_genesys.xlsx", Constants.ASSOC_CONTAINS, null);
            
            FileInputStream fileInputStream=null;
            
            File file = new File("C:\\test\\test_genesys.xlsx");
            byte[] bFile = new byte[(int) file.length()];
            
            	try {
            		//convert file into array of bytes
            		fileInputStream = new FileInputStream(file);
            		fileInputStream.read(bFile);
            		fileInputStream.close();
    	    
            		for (int i = 0; i < bFile.length; i++) {
            			System.out.print((char)bFile[i]);
            		}
    	    
            		System.out.println("Done");
            		}catch(Exception e){
            			e.printStackTrace();
            		}
            
            ContentServiceSoapBindingStub contentService = WebServiceFactory.getContentService();	
            ContentFormat contentFormat = new ContentFormat("xlsx", "UTF-8");
            Content contentRef = contentService.write(parent, Constants.PROP_CONTENT, bFile, contentFormat);
            System.out.println("Content Length: " + contentRef.getLength());
            
                        
        }
        catch(Throwable e)
        {
            System.out.println(e.toString());
        }
        
        //File number 2
        try
        {
        	// Create a reference to the parent where we want to create content
            Store storeRef = new Store(Constants.WORKSPACE_STORE, "SpacesStore");
            ParentReference parent = new ParentReference(storeRef, null, "/app:company_home/cm:test_genesys2.xlsx", Constants.ASSOC_CONTAINS, null);
            
            FileInputStream fileInputStream=null;
            
            File file = new File("C:\\test\\test_genesys2.xlsx");
            byte[] bFile = new byte[(int) file.length()];
            
            	try {
            		//convert file into array of bytes
            		fileInputStream = new FileInputStream(file);
            		fileInputStream.read(bFile);
            		fileInputStream.close();
    	    
            		for (int i = 0; i < bFile.length; i++) {
            			System.out.print((char)bFile[i]);
            		}
    	    
            		System.out.println("Done");
            		}catch(Exception e){
            			e.printStackTrace();
            		}
            
            ContentServiceSoapBindingStub contentService = WebServiceFactory.getContentService();	
            ContentFormat contentFormat = new ContentFormat("xlsx", "UTF-8");
            Content contentRef = contentService.write(parent, Constants.PROP_CONTENT, bFile, contentFormat);
            System.out.println("Content Length: " + contentRef.getLength());
            
                        
        }
        catch(Throwable e)
        {
            System.out.println(e.toString());
        }
        finally
        {
            // End the session
            AuthenticationUtils.endSession();
            System.exit(0);
        }
    }
    	
}
