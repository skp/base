package http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.DefaultedHttpParams;
import org.apache.http.params.HttpParams;

/**
 * 说明
 * 利用httpclient下载文件
 * maven依赖
 * <dependency>
 * <groupId>org.apache.httpcomponents</groupId>
 * <artifactId>httpclient</artifactId>
 * <version>4.0.1</version>
 * </dependency>
 * 可下载http文件、图片、压缩文件
 * bug：获取response header中Content-Disposition中filename中文乱码问题
 *
 * @author tanjundong
 */
public class HttpDownload {

	public static final int cache = 10 * 1024;
	public static final boolean isWindows;
	public static final String splash;
	public static final String root;

	static {
		if (System.getProperty("os.name") != null && System.getProperty("os.name").toLowerCase().contains("windows")) {
			isWindows = true;
			splash = "\\";
			root = "D:";
		} else {
			isWindows = false;
			splash = "/";
			root = "/search";
		}
	}

	/**
	 * 根据url下载文件，文件名从response header头中获取
	 *
	 * @param url
	 *
	 * @return
	 */
	/*public static String download(String url) {
		return download(url, null);
	}*/

	/**
	 * 根据url下载文件，保存到filepath中
	 *
	 * @param url
	 * @param filepath
	 *
	 * @return
	 */
	public static String download(CloseableHttpClient client, String url, String filepath, Header[] headers) {
		try {
			// CloseableHttpClient client = HttpClients.createDefault();
			for (int j = 1; j < 104; j++) {
				String u1 = url.replaceAll("#", j + "");
				for (int i = 0; i < 49; i++) {
					String u2 = u1.replaceAll("\\*", i + "");

					HttpGet httpget = new HttpGet(u2);
					httpget.setHeaders(headers);

					HttpResponse response = client.execute(httpget);

					HttpEntity entity = response.getEntity();
					InputStream is = entity.getContent();
				/*if (filepath == null) {
					filepath = getFilePath(response);
				}*/
					String[] urlSplitArr = u2.split("/");
					filepath = "D:\\test\\" + urlSplitArr[urlSplitArr.length - 1];
					File file = new File(filepath);
					file.getParentFile().mkdirs();
					FileOutputStream fileout = new FileOutputStream(file);
					/**
					 * 根据实际运行效果 设置缓冲区大小
					 */
					byte[] buffer = new byte[cache];
					int ch = 0;
					while ((ch = is.read(buffer)) != -1) {
						fileout.write(buffer, 0, ch);
					}
					is.close();
					fileout.flush();
					fileout.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取response要下载的文件的默认路径
	 *
	 * @param response
	 *
	 * @return
	 */
	public static String getFilePath(HttpResponse response) {
		String filepath = root + splash;
		String filename = getFileName(response);

		if (filename != null) {
			filepath += filename;
		} else {
			filepath += getRandomFileName();
		}
		return filepath;
	}

	/**
	 * 获取response header中Content-Disposition中的filename值
	 *
	 * @param response
	 *
	 * @return
	 */
	public static String getFileName(HttpResponse response) {
		Header contentHeader = response.getFirstHeader("Content-Disposition");
		String filename = null;
		if (contentHeader != null) {
			HeaderElement[] values = contentHeader.getElements();
			if (values.length == 1) {
				NameValuePair param = values[0].getParameterByName("filename");
				if (param != null) {
					try {
						//filename = new String(param.getValue().toString().getBytes(), "utf-8");
						//filename=URLDecoder.decode(param.getValue(),"utf-8");
						filename = param.getValue();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return filename;
	}

	/**
	 * 获取随机文件名
	 *
	 * @return
	 */
	public static String getRandomFileName() {
		return String.valueOf(System.currentTimeMillis());
	}

	public static void outHeaders(HttpResponse response) {
		Header[] headers = response.getAllHeaders();
		for (int i = 0; i < headers.length; i++) {
			System.out.println(headers[i]);
		}
	}

	public static void main(String[] args) {
		String url = "http://fwpt.ngac.cn/dzxxcp/admin_file/core/file/detailOnLine.do?id=4028b8815f14d74e015f18e8a3ef03ce&pstatus=img&t=deepzoom&path=15/#_*.png";
		// String filepath = "D:\\test\\a.png";
		CloseableHttpClient client = HttpClients.createDefault();
		Header[] headers = new Header[8];
		headers[0] = new BasicHeader("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
		headers[1] = new BasicHeader("Accept-Encoding", "gzip, deflate");
		headers[2] = new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9,zh-TW;q=0.8,en-US;q=0.7,en;q=0.6");
		headers[3] = new BasicHeader("Connection", "keep-alive");
		headers[4] = new BasicHeader("Cookie", "JSESSIONID=8794FACAF11D05E3B1F15A281AC63DF1");
		headers[5] = new BasicHeader("Host", "fwpt.ngac.cn");
		headers[6] = new BasicHeader("Referer", "http://fwpt.ngac.cn/dzxxcp/admin_file/core/file/toView.do?id=4028b8815f14d74e015f18e8a3ef03ce&t=deepzoom");
		headers[7] = new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
		HttpDownload.download(client, url, null, headers);


	}
}