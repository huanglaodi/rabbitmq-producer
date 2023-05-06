package com.example.rabbitmqproducer.test;

import com.alibaba.fastjson.JSON;
import com.example.rabbitmqproducer.model.User;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class EsApiApplicationTests {

    private static final String index_name = "user_info";


    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    /**
     * 创建一个索引库
     *
     * @throws IOException
     */
    @Test
    void createIndex() throws IOException {
        boolean result = elasticsearchRestTemplate.createIndex("liqiang");
        System.out.println(result);
   /* CreateIndexRequest createIndexRequest = new CreateIndexRequest(index_name);
    CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
    //打印创建结果
    System.out.println(createIndexResponse.isAcknowledged());*/
    }

    /**
     * 判断索引库是否存在
     */
    @Test
    void searchIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("liqiang");
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * 删除索引库
     */
    @Test
    void removeIndex() throws IOException {

        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(index_name);
        AcknowledgedResponse response = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        //打印删除结果
        System.out.println(response.isAcknowledged());
    }

    /**
     * 创建文档
     */
    @Test
    void createDoc() throws IOException {
        User user = new User("张三", 22, "北京市");
        IndexRequest indexRequest = new IndexRequest(index_name, DocWriteRequest.OpType.CREATE.toString());
        indexRequest.id("2");
        // indexRequest.timeout("1s");
        IndexRequest request = indexRequest.source(JSON.toJSONString(user), XContentType.JSON);
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }

    /**
     * 查询文档
     */
    @Test
    void queryDoc() throws IOException {
        GetRequest getRequest = new GetRequest(index_name, DocWriteRequest.OpType.CREATE.toString(), "2");
        GetResponse response = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(response.getSource());
    }

    /**
     * 修改文档
     */
    @Test
    void updateDoc() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest(index_name, DocWriteRequest.OpType.CREATE.toString(), "2");
        User user = new User("李四", 55, "成都市");
        updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);
        updateRequest.timeout("1s");
        UpdateResponse response = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }

    /**
     * 删除指定文档
     */
    @Test
    void removeDoc() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(index_name, null, "1");
        DeleteResponse response = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }

    /**
     * 批量插入文档
     */
    @Test
    void bulkCreateDoc() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");
        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            userList.add(new User("张三" + i, 25 + i, "成都" + i));
        }
        for (int i = 0; i < userList.size(); i++) {
            bulkRequest.add(new IndexRequest(index_name)
                    .id(String.valueOf(i))
                    .type(DocWriteRequest.OpType.CREATE.toString())
                    .source(JSON.toJSONString(userList.get(i)), XContentType.JSON));
        }
        BulkResponse response = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }

    /**
     * 批量查询文档
     */
    @Test
    void queryDocList() throws IOException {
        SearchRequest searchRequest = new SearchRequest(index_name);


        //指定条件查询
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //查询年龄为25的index_info索引库中的数据
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("age", 25);
        searchSourceBuilder.query(termQueryBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }


        //查询索引库中所有的文档数据
       /* SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }*/
    }


    @Test
    public void testEquals(){
        /*Integer i = 12;
        Integer t = 12;
        Integer o = new Integer(12);
        boolean y = t==i;
        boolean z = i==o;
        System.out.println(" y:"+y+"  z:"+z);*/

        /*int[] a ;
        int[] b = {1,2,3};
        int[] c = new int[]{1,2,3};
        a = new int[2];
        a[0] = 1;
        a[1] = 2;
        for(int x=0;x<a.length; x++){
            System.out.println(a[x]);
        }*/


    }


    @Test
    public void testMath(){
       /*int i = (int)Math.ceil(-11.3);
       int y = (int)Math.ceil(11.1);*/

        /*int ii = (int)Math.floor(-11.3);
        int yy = (int)Math.floor(11.1);*/

        int i = (int)Math.round(11.3);
        int y = (int)Math.round(11.5);
        int u = (int)Math.round(-11.3);
        int q = (int)Math.round(-11.5);
        int z = (int)Math.round(-11.6);
       System.out.println(i+"===="+y+"===="+u+"===="+q+"===="+z);


    }


    @Test
    public void testString(){
       /* String y = new String("dd");
        String i = "dd";
        String z = new String("ee");
        String w = y+z;
        String r = "ddee";
        boolean x = w.hashCode() == r.hashCode();

        Byte xx = 127 ;
        Byte yy = 127;
        xx++;
        byte aa = (byte)(yy+2);
        System.out.println(xx+"====="+(byte)(yy+2));*/

        /*float x = 0.330000001f;
        float y = 0.330001f;
        BigDecimal xx = new BigDecimal(x).setScale(7,BigDecimal.ROUND_UP);
        BigDecimal yy = new BigDecimal(y).setScale(7,BigDecimal.ROUND_UP);
        int ii = xx.compareTo(yy);
        int z = Float.valueOf(x).compareTo(y);
        float p = Math.abs(x-y);
        System.out.println();*/

        List a = new ArrayList();
        int x = a.size();
        a.add(2);
        int y = a.size();


    }
}
