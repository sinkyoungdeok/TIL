import {Module} from '@nestjs/common';
import {BoardsController} from './boards.controller';
import {BoardsService} from './boards.service';
import {TypeOrmModule} from "@nestjs/typeorm";
import {Board} from "./board.entity";

@Module({
  imports: [
    TypeOrmModule.forFeature([Board])
  ],
  controllers: [BoardsController],
  providers: [BoardsService,],
})
export class BoardsModule {
}
