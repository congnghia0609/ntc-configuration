package com.ntc.configer;

import java.io.InputStream;
import java.net.URL;
import javax.annotation.Resource;

/**
 * ResourceUtils. Provide a set of convenience methods for working with
 * Resources.
 * 
 * @see org.apache.log4j.lf5.util.Resource
 * 
 * @author Michael J. Sikorsky
 * @author Robert Shaw
 */
//Contributed by ThoughtWorks Inc.
public class ResourceUtils {
    //--------------------------------------------------------------------------
    //   Constants:
    //--------------------------------------------------------------------------

    //--------------------------------------------------------------------------
    //   Protected Variables:
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //   Private Variables:
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //   Constructors:
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //   Public Methods:
    //--------------------------------------------------------------------------
    /**
     * Get the InputStream for this resource. Note: to convert an InputStream
     * into an InputReader, use: new InputStreamReader(InputStream).
     *
     * @param object The object to grab the Classloader from. This parameter is
     * quite important from a visibility of resources standpoint as the
     * hierarchy of Classloaders plays a role.
     *
     * @param resource The resource to load.
     *
     * @return If the Resource was found, the InputStream, otherwise null.
     *
     * @see Resource
     * @see #getResourceAsURL(Object,Resource)
     * @see InputStream
     */
    public static InputStream getResourceAsStream(String name) {
        ClassLoader loader = ResourceUtils.class.getClass().getClassLoader();

        InputStream in = null;

        if (loader != null) {
            in = loader.getResourceAsStream(name);
        } else {
            in = ClassLoader.getSystemResourceAsStream(name);
        }

        return in;
    }

    /**
     * Get the URL for this resource.
     *
     * @param object The object to grab the Classloader from. This parameter is
     * quite important from a visibility of resources standpoint as the
     * hierarchy of Classloaders plays a role.
     *
     * @param resource The resource to load.
     *
     * @return If the Resource was found, the URL, otherwise null.
     *
     * @see Resource
     * @see #getResourceAsStream(Object,Resource)
     */
    public static URL getResourceAsURL(String name) {
        ClassLoader loader = ResourceUtils.class.getClassLoader();

        URL url = null;

        if (loader != null) {
            url = loader.getResource(name);
        } else {
            url = ClassLoader.getSystemResource(name);
        }

        return (url);
    }

    //--------------------------------------------------------------------------
    //   Protected Methods:
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //   Private Methods:
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //   Nested Top-Level Classes or Interfaces:
    //--------------------------------------------------------------------------
}
