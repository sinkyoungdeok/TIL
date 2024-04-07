import {Module} from '@nestjs/common';
import {BoardsModule} from './boards/boards.module';
import {TypeOrmModule} from "@nestjs/typeorm";
import {typeORMconfig} from "./config/typeorm.config";

@Module({
  imports: [
    TypeOrmModule.forRoot(typeORMconfig),
    BoardsModule
  ],
})
export class AppModule {
}
