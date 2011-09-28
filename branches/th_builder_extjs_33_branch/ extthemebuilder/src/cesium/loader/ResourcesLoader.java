package cesium.loader;

import cesium.factory.ResourcesLoaderFactory;
import cesium.holder.ResourcesHolder;
import cesium.theme.settings.ThemeSettings;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @project: Theme Builder for ExtJS 3.x
 * @Description:
 * @license: LGPL_v3
 * @author: Sergey Chentsov (extjs id: iv_ekker)
 * @mailto: sergchentsov@gmail.com
 * @version: 1.0.0
 * @Date: 11.08.2009
 * @Time: 10:52:32
 */
public interface ResourcesLoader {

    public String getResourcesPath();

    public void setResourcesPath(String path);

    public ResourcesHolder loadResources(String resourcesPath
            , ApplicationContext context, ThemeSettings themeSettings);

    public ResourcesHolder loadResources(String resourcesPath
            , ApplicationContext context
            , ServletContext servletContext, ThemeSettings themeSettings);

    public ResourcesHolder loadResources(InputStream resource,
                                         ApplicationContext context
            , String resourcePath, ThemeSettings themeSettings);

    public ResourcesLoaderFactory getResourcesLoaderFactory();

    public void setResourcesLoaderFactory(ResourcesLoaderFactory resourcesLoaderFactory);

    public void unloadResources(ResourcesHolder holder, ApplicationContext context, Object destination);

    public OutputStream outForWeb(ResourcesHolder holder, String thisControllerUrl, String resourcesPath);

    public ZipOutputStream outForZip(ResourcesHolder holder, String resourcesPath,
                                     ZipOutputStream zipOS, ApplicationContext context, String newSchemaName, String templateName, String version)
            throws IOException;

}
