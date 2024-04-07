import { TypeOrmModuleOptions } from '@nestjs/typeorm';

export const typeORMconfig: TypeOrmModuleOptions = {
  type: 'postgres',
  host: 'localhost',
  port: 5432,
  username: 'user',
  password: 'test_user',
  database: 'boarda-app',
  entities: [__dirname + '/../**/*.entity.{js,ts}'],
  synchronize: true,
}