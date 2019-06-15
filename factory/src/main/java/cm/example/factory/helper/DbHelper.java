package cm.example.factory.helper;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;

import java.util.Arrays;

import cm.example.factory.model.AppDatabase;

public class DbHelper {
    private static final DbHelper instance;

    static {
        instance = new DbHelper();
    }

    public static <Model extends BaseModel> void save(final Class<Model> tClass,
                                                      final Model... models) {
        if (models == null || models.length == 0)
            return;

        // 当前数据库的一个管理者
        DatabaseDefinition definition = FlowManager.getDatabase(AppDatabase.class);
        // 提交一个事物
        definition.beginTransactionAsync(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
                // 执行
                ModelAdapter<Model> adapter = FlowManager.getModelAdapter(tClass);
                // 保存
                adapter.saveAll(Arrays.asList(models));

            }
        }).build().execute();
    }
}
