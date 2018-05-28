/*
 * Copyright © 2013-2016 The Nxt Core Developers.
 * Copyright © 2016-2017 Jelurida IP B.V.
 * Copyright © 2017 The XEL Core Developers.
 *
 * See the LICENSE.txt file at the top-level directory of this distribution
 * for licensing information.
 *
 * Unless otherwise agreed in a custom licensing agreement with Jelurida B.V.,
 * no part of the Nxt software, including this file, may be copied, modified,
 * propagated, or distributed except according to the terms contained in the
 * LICENSE.txt file.
 *
 * Removal or modification of this copyright notice is prohibited.
 *
 */

package org.xel;

import org.xel.db.DbVersion;
import org.xel.util.Convert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class NxtDbVersion extends DbVersion {

    protected void update(int nextUpdate) {
        switch (nextUpdate) {
            case 1:
                apply("CREATE TABLE IF NOT EXISTS block (db_id IDENTITY, id BIGINT NOT NULL, version INT NOT NULL, "
                        + "timestamp INT NOT NULL, previous_block_id BIGINT, "
                        + "total_amount BIGINT NOT NULL, "
                        + "total_fee BIGINT NOT NULL, payload_length INT NOT NULL, "
                        + "previous_block_hash BINARY(32), cumulative_difficulty VARBINARY NOT NULL, base_target BIGINT NOT NULL, "
                        + "next_block_id BIGINT, "
                        + "height INT NOT NULL, generation_signature BINARY(64) NOT NULL, "
                        + "block_signature BINARY(64) NOT NULL, payload_hash BINARY(32) NOT NULL, generator_id BIGINT NOT NULL)");
            case 2:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS block_id_idx ON block (id)");
            case 3:
                apply("CREATE TABLE IF NOT EXISTS transaction (db_id IDENTITY, id BIGINT NOT NULL, "
                        + "deadline SMALLINT NOT NULL, recipient_id BIGINT, "
                        + "amount BIGINT NOT NULL, fee BIGINT NOT NULL, full_hash BINARY(32) NOT NULL, "
                        + "height INT NOT NULL, block_id BIGINT NOT NULL, FOREIGN KEY (block_id) REFERENCES block (id) ON DELETE CASCADE, "
                        + "signature BINARY(64) NOT NULL, timestamp INT NOT NULL, type TINYINT NOT NULL, subtype TINYINT NOT NULL, "
                        + "sender_id BIGINT NOT NULL, block_timestamp INT NOT NULL, referenced_transaction_full_hash BINARY(32), "
                        + "transaction_index SMALLINT NOT NULL, phased BOOLEAN NOT NULL DEFAULT FALSE, "
                        + "attachment_bytes VARBINARY, version TINYINT NOT NULL, has_message BOOLEAN NOT NULL DEFAULT FALSE, "
                        + "has_encrypted_message BOOLEAN NOT NULL DEFAULT FALSE, has_public_key_announcement BOOLEAN NOT NULL DEFAULT FALSE, "
                        + "has_prunable_message BOOLEAN NOT NULL DEFAULT FALSE, has_prunable_attachment BOOLEAN NOT NULL DEFAULT FALSE, "
                        + "ec_block_height INT DEFAULT NULL, ec_block_id BIGINT DEFAULT NULL, has_encrypttoself_message BOOLEAN NOT NULL DEFAULT FALSE)");
            case 4:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS transaction_id_idx ON transaction (id)");
            case 5:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS block_height_idx ON block (height)");
            case 6:
                apply(null);
            case 7:
                apply("CREATE INDEX IF NOT EXISTS block_generator_id_idx ON block (generator_id)");
            case 8:
                apply("CREATE INDEX IF NOT EXISTS transaction_sender_id_idx ON transaction (sender_id)");
            case 9:
                apply("CREATE INDEX IF NOT EXISTS transaction_recipient_id_idx ON transaction (recipient_id)");
            case 10:
                this.apply(
                        "CREATE TABLE IF NOT EXISTS redeems (db_id IDENTITY, id BIGINT NOT NULL, address VARCHAR, secp_signatures VARCHAR, receiver_id BIGINT NOT NULL, amount BIGINT NOT NULL, block_timestamp INT NOT NULL, timestamp INT NOT NULL, height INT NOT NULL, "
                                + "FOREIGN KEY (height) REFERENCES block (height) ON DELETE CASCADE, latest BOOLEAN NOT NULL DEFAULT TRUE)");
            case 11:
                apply("CREATE INDEX IF NOT EXISTS redeem_address ON redeems (address)");
            case 12:
                apply("CREATE INDEX IF NOT EXISTS redeem_height ON redeems (height)");
            case 13:
                apply(null);
            case 14:
                apply(null);
            case 15:
                apply(null);
            case 16:
                apply(null);
            case 17:
                apply(null);
            case 18:
                apply(null);
            case 19:
                apply(null);
            case 20:
                apply(null);
            case 21:
                apply(null);
            case 22:
                apply(null);
            case 23:
                apply(null);
            case 24:
                apply(null);
            case 25:
                apply(null);
            case 26:
                apply(null);
            case 27:
                apply(null);
            case 28:
                apply(null);
            case 29:
                apply(null);
            case 30:
                apply(null);
            case 31:
                apply(null);
            case 32:
                apply(null);
            case 33:
                apply(null);
            case 34:
                apply(null);
            case 35:
                apply(null);
            case 36:
                apply("CREATE TABLE IF NOT EXISTS peer (address VARCHAR PRIMARY KEY, last_updated INT, services BIGINT)");
            case 37:
                apply(null);
            case 38:
                apply(null);
            case 39:
                apply(null);
            case 40:
                apply(null);
            case 41:
                apply(null);
            case 42:
                apply(null);
            case 43:
                apply(null);
            case 44:
                apply(null);
            case 45:
                apply(null);
            case 46:
                apply(null);
            case 47:
                apply(null);
            case 48:
                apply(null);
            case 49:
                apply(null);
            case 50:
                apply(null);
            case 51:
                apply(null);
            case 52:
                apply(null);
            case 53:
                apply(null);
            case 54:
                apply(null);
            case 55:
                apply(null);
            case 56:
                apply(null);
            case 57:
                apply(null);
            case 58:
                apply(null);
            case 59:
                apply(null);
            case 60:
                apply(null);
            case 61:
                apply(null);
            case 62:
                apply(null);
            case 63:
                apply(null);
            case 64:
                apply(null);
            case 65:
                apply(null);
            case 66:
                apply(null);
            case 67:
                apply(null);
            case 68:
                apply(null);
            case 69:
                apply("CREATE INDEX IF NOT EXISTS transaction_block_timestamp_idx ON transaction (block_timestamp DESC)");
            case 70:
                apply(null);
            case 71:
                apply(null);
            case 72:
                apply(null);
            case 73:
                apply(null);
            case 74:
                apply(null);
            case 75:
                apply(null);
            case 76:
                apply(null);
            case 77:
                apply(null);
            case 78:
                apply(null);
            case 79:
                apply(null);
            case 80:
                apply(null);
            case 81:
                apply(null);
            case 82:
                apply(null);
            case 83:
                apply(null);
            case 84:
                apply(null);
            case 85:
                apply(null);
            case 86:
                apply(null);
            case 87:
                apply(null);
            case 88:
                apply(null);
            case 89:
                apply(null);
            case 90:
                apply(null);
            case 91:
                apply(null);
            case 92:
                apply(null);
            case 93:
                apply(null);
            case 94:
                apply(null);
            case 95:
                apply(null);
            case 96:
                apply(null);
            case 97:
                apply(null);
            case 98:
                apply(null);
            case 99:
                apply(null);
            case 100:
                apply(null);
            case 101:
                apply(null);
            case 102:
                apply("CREATE TABLE IF NOT EXISTS account (db_id IDENTITY, id BIGINT NOT NULL, "
                        + "balance BIGINT NOT NULL, unconfirmed_balance BIGINT NOT NULL, "
                        + "forged_balance BIGINT NOT NULL, active_lessee_id BIGINT, has_control_phasing BOOLEAN NOT NULL DEFAULT FALSE, "
                        + "height INT NOT NULL, latest BOOLEAN NOT NULL DEFAULT TRUE)");
            case 103:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS account_id_height_idx ON account (id, height DESC)");
            case 104:
                apply(null);
            case 105:
                apply(null);
            case 106:
                apply(null);
            case 107:
                apply("CREATE TABLE IF NOT EXISTS account_guaranteed_balance (db_id IDENTITY, account_id BIGINT NOT NULL, "
                        + "additions BIGINT NOT NULL, height INT NOT NULL)");
            case 108:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS account_guaranteed_balance_id_height_idx ON account_guaranteed_balance "
                        + "(account_id, height DESC)");
            case 109:
                apply(null);
            case 110:
                apply(null);
            case 111:
                apply(null);
            case 112:
                apply(null);
            case 113:
                apply("CREATE TABLE IF NOT EXISTS unconfirmed_transaction (db_id IDENTITY, id BIGINT NOT NULL, expiration INT NOT NULL, "
                        + "transaction_height INT NOT NULL, fee_per_byte BIGINT NOT NULL, arrival_timestamp BIGINT NOT NULL, "
                        + "transaction_bytes VARBINARY NOT NULL, height INT NOT NULL)");
            case 114:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS unconfirmed_transaction_id_idx ON unconfirmed_transaction (id)");
            case 115:
                apply(null);
            case 116:
                apply(null);
            case 117:
                apply(null);
            case 118:
                apply(null);
            case 119:
                apply(null);
            case 120:
                apply(null);
            case 121:
                apply(null);
            case 122:
                apply(null);
            case 123:
                apply(null);
            case 124:
                apply(null);
            case 125:
                apply(null);
            case 126:
                apply(null);
            case 127:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS block_timestamp_idx ON block (timestamp DESC)");
            case 128:
                apply(null);
            case 129:
                apply(null);
            case 130:
                apply(null);
            case 131:
                apply(null);
            case 132:
                apply(null);
            case 133:
                apply(null);
            case 134:
                apply(null);
            case 135:
                apply(null);
            case 136:
                apply(null);
            case 137:
                apply(null);
            case 138:
                apply(null);
            case 139:
                apply(null);
            case 140:
                apply(null);
            case 141:
                apply(null);
            case 142:
                apply(null);
            case 143:
                apply(null);

            case 144:
                apply(null);
            case 145:
                apply(null);
            case 146:
                apply(null);
            case 147:
                apply(null);
            case 148:
                apply(null);
            case 149:
                apply(null);
            case 150:
                apply(null);
            case 151:
                apply(null);
            case 152:
                apply(null);
            case 153:
                apply(null);

            case 154:
                apply(null);
            case 155:
                apply(null);
            case 156:
                apply(null);
            case 157:
                apply(null);
            case 158:
                apply(null);
            case 159:
                apply(null);
            case 160:
                apply(null);
            case 161:
                apply(null);
            case 162:
                apply(null);
            case 163:
                apply(null);
            case 164:
                apply(null);
            case 165:
                apply(null);
            case 166:
                apply(null);
            case 167:
                apply(null);
            case 168:
                apply(null);
            case 169:
                apply(null);
            case 170:
                apply("DROP INDEX IF EXISTS unconfirmed_transaction_height_fee_timestamp_idx");
            case 171:
                apply("ALTER TABLE unconfirmed_transaction DROP COLUMN IF EXISTS timestamp");
            case 172:
                apply("ALTER TABLE unconfirmed_transaction ADD COLUMN IF NOT EXISTS arrival_timestamp BIGINT NOT NULL DEFAULT 0");
            case 173:
                apply("CREATE INDEX IF NOT EXISTS unconfirmed_transaction_height_fee_timestamp_idx ON unconfirmed_transaction "
                        + "(transaction_height ASC, fee_per_byte DESC, arrival_timestamp ASC)");
            case 174:
                BlockDb.deleteAll();
                apply(null);
            case 175:
                apply("ALTER TABLE transaction ADD COLUMN IF NOT EXISTS transaction_index SMALLINT NOT NULL");
            case 176:
                apply(null);
            case 177:
                apply(null);
            case 178:
                apply(null);
            case 179:
                apply(null);
            case 180:
                apply(null);
            case 181:
                apply(null);
            case 182:
                apply(null);
            case 183:
                apply(null);
            case 184:
                apply("CREATE TABLE IF NOT EXISTS scan (rescan BOOLEAN NOT NULL DEFAULT FALSE, height INT NOT NULL DEFAULT 0, "
                        + "validate BOOLEAN NOT NULL DEFAULT FALSE)");
            case 185:
                apply("INSERT INTO scan (rescan, height, validate) VALUES (false, 0, false)");
            case 186:
                apply(null);
            case 187:
                apply(null);
            case 188:
                apply(null);
            case 189:
                apply(null);
            case 190:
                apply(null);
            case 191:
                apply(null);
            case 192:
                apply(null);
            case 193:
                apply(null);
            case 194:
                apply(null);
            case 195:
                apply(null);
            case 196:
                apply(null);
            case 197:
                apply(null);
            case 198:
                apply(null);
            case 199:
                apply(null);
            case 200:
                apply("CREATE TABLE IF NOT EXISTS public_key (db_id IDENTITY, account_id BIGINT NOT NULL, "
                        + "public_key BINARY(32), height INT NOT NULL, FOREIGN KEY (height) REFERENCES block (height) ON DELETE CASCADE, "
                        + "latest BOOLEAN NOT NULL DEFAULT TRUE)");
            case 201:
                apply(null);
            case 202:
                apply(null);
            case 203:
                apply("ALTER TABLE account DROP COLUMN IF EXISTS public_key");
            case 204:
                apply("ALTER TABLE block DROP COLUMN IF EXISTS generator_public_key");
            case 205:
                apply("ALTER TABLE transaction DROP COLUMN IF EXISTS sender_public_key");
            case 206:
                apply(null);
            case 207:
                apply(null);
            case 208:
                apply(null);
            case 209:
                apply("CREATE INDEX IF NOT EXISTS account_guaranteed_balance_height_idx ON account_guaranteed_balance(height)");
            case 210:
                apply(null);
            case 211:
                apply(null);
            case 212:
                apply(null);
            case 213:
                apply(null);
            case 214:
                apply(null);
            case 215:
                apply(null);
            case 216:
                apply(null);
            case 217:
                apply(null);
            case 218:
                apply(null);
            case 219:
                apply(null);
            case 220:
                apply(null);
            case 221:
                apply(null);
            case 222:
                apply(null);
            case 223:
                apply(null);
            case 224:
                apply(null);
            case 225:
                apply(null);
            case 226:
                apply(null);
            case 227:
                apply(null);
            case 228:
                apply(null);
            case 229:
                apply(null);
            case 230:
                apply(null);
            case 231:
                BlockDb.deleteBlocksFromHeight(Constants.PHASING_BLOCK);
                apply("DROP TABLE IF EXISTS poll");
            case 232:
                apply("DROP TABLE IF EXISTS vote");
            case 233:
                apply("CREATE TABLE IF NOT EXISTS vote (db_id IDENTITY, id BIGINT NOT NULL, " +
                        "poll_id BIGINT NOT NULL, voter_id BIGINT NOT NULL, vote_bytes VARBINARY NOT NULL, height INT NOT NULL)");
            case 234:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS vote_id_idx ON vote (id)");
            case 235:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS vote_poll_id_idx ON vote (poll_id, voter_id)");
            case 236:
                apply("CREATE TABLE IF NOT EXISTS poll (db_id IDENTITY, id BIGINT NOT NULL, "
                        + "account_id BIGINT NOT NULL, name VARCHAR NOT NULL, "
                        + "description VARCHAR, options ARRAY NOT NULL, min_num_options TINYINT, max_num_options TINYINT, "
                        + "min_range_value TINYINT, max_range_value TINYINT, timestamp INT NOT NULL, "
                        + "finish_height INT NOT NULL, voting_model TINYINT NOT NULL, min_balance BIGINT, "
                        + "min_balance_model TINYINT, holding_id BIGINT, height INT NOT NULL)");
            case 237:
                apply("CREATE TABLE IF NOT EXISTS poll_result (db_id IDENTITY, poll_id BIGINT NOT NULL, "
                        + "result BIGINT, weight BIGINT NOT NULL, height INT NOT NULL)");
            case 238:
                apply("ALTER TABLE transaction ADD COLUMN IF NOT EXISTS phased BOOLEAN NOT NULL DEFAULT FALSE");
            case 239:
                apply("CREATE TABLE IF NOT EXISTS phasing_poll (db_id IDENTITY, id BIGINT NOT NULL, "
                        + "account_id BIGINT NOT NULL, whitelist_size TINYINT NOT NULL DEFAULT 0, "
                        + "finish_height INT NOT NULL, voting_model TINYINT NOT NULL, quorum BIGINT, "
                        + "min_balance BIGINT, holding_id BIGINT, min_balance_model TINYINT, "
                        + "hashed_secret VARBINARY, algorithm TINYINT, height INT NOT NULL)");
            case 240:
                apply("CREATE TABLE IF NOT EXISTS phasing_vote (db_id IDENTITY, vote_id BIGINT NOT NULL, "
                        + "transaction_id BIGINT NOT NULL, voter_id BIGINT NOT NULL, "
                        + "height INT NOT NULL)");
            case 241:
                apply("CREATE TABLE IF NOT EXISTS phasing_poll_voter (db_id IDENTITY, "
                        + "transaction_id BIGINT NOT NULL, voter_id BIGINT NOT NULL, "
                        + "height INT NOT NULL)");
            case 242:
                apply("CREATE INDEX IF NOT EXISTS vote_height_idx ON vote(height)");
            case 243:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS poll_id_idx ON poll(id)");
            case 244:
                apply("CREATE INDEX IF NOT EXISTS poll_height_idx ON poll(height)");
            case 245:
                apply("CREATE INDEX IF NOT EXISTS poll_account_idx ON poll(account_id)");
            case 246:
                apply("CREATE INDEX IF NOT EXISTS poll_finish_height_idx ON poll(finish_height DESC)");
            case 247:
                apply("CREATE INDEX IF NOT EXISTS poll_result_poll_id_idx ON poll_result(poll_id)");
            case 248:
                apply("CREATE INDEX IF NOT EXISTS poll_result_height_idx ON poll_result(height)");
            case 249:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS phasing_poll_id_idx ON phasing_poll(id)");
            case 250:
                apply("CREATE INDEX IF NOT EXISTS phasing_poll_height_idx ON phasing_poll(height)");
            case 251:
                apply("CREATE INDEX IF NOT EXISTS phasing_poll_account_id_idx ON phasing_poll(account_id, height DESC)");
            case 252:
                apply("CREATE INDEX IF NOT EXISTS phasing_poll_holding_id_idx ON phasing_poll(holding_id, height DESC)");
            case 253:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS phasing_vote_transaction_voter_idx ON phasing_vote(transaction_id, voter_id)");
            case 254:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS phasing_poll_voter_transaction_voter_idx ON phasing_poll_voter(transaction_id, voter_id)");
            case 255:
                apply("CREATE TABLE IF NOT EXISTS phasing_poll_result (db_id IDENTITY, id BIGINT NOT NULL, "
                        + "result BIGINT NOT NULL, approved BOOLEAN NOT NULL, height INT NOT NULL)");
            case 256:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS phasing_poll_result_id_idx ON phasing_poll_result(id)");
            case 257:
                apply("CREATE INDEX IF NOT EXISTS phasing_poll_result_height_idx ON phasing_poll_result(height)");
            case 258:
                apply(null);
            case 259:
                apply(null);
            case 260:
                apply(null);
            case 261:
                apply("CREATE INDEX IF NOT EXISTS phasing_poll_voter_height_idx ON phasing_poll_voter(height)");
            case 262:
                apply(null);
            case 263:
                apply(null);
            case 264:
                apply(null);
            case 265:
                apply(null);
            case 266:
                apply(null);
            case 267:
                apply(null);
            case 268:
                apply(null);
            case 269:
                apply(null);
            case 270:
                apply("CREATE INDEX IF NOT EXISTS phasing_vote_height_idx ON phasing_vote(height)");
            case 271:
                apply("DROP INDEX IF EXISTS transaction_full_hash_idx");
            case 272:
                apply("DROP INDEX IF EXISTS trade_ask_bid_idx");
            case 273:
                apply(null);
            case 274:
                apply(null);
            case 275:
                apply("CREATE TABLE IF NOT EXISTS account_info (db_id IDENTITY, account_id BIGINT NOT NULL, "
                        + "name VARCHAR, description VARCHAR, height INT NOT NULL, latest BOOLEAN NOT NULL DEFAULT TRUE)");
            case 276:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS account_info_id_height_idx ON account_info (account_id, height DESC)");
            case 277:
                apply(null);
            case 278:
                apply("ALTER TABLE account DROP COLUMN IF EXISTS name");
            case 279:
                apply("ALTER TABLE account DROP COLUMN IF EXISTS description");
            case 280:
                apply("ALTER TABLE account DROP COLUMN IF EXISTS message_pattern_regex");
            case 281:
                apply("ALTER TABLE account DROP COLUMN IF EXISTS message_pattern_flags");
            case 282:
                apply(null);
            case 283:
                apply("TRUNCATE TABLE poll");
            case 284:
                apply("ALTER TABLE poll ADD COLUMN IF NOT EXISTS timestamp INT NOT NULL");
            case 285:
                apply(null);
            case 286:
                apply("CREATE TABLE IF NOT EXISTS prunable_message (db_id IDENTITY, id BIGINT NOT NULL, sender_id BIGINT NOT NULL, "
                        + "recipient_id BIGINT, message VARBINARY NOT NULL, is_text BOOLEAN NOT NULL, is_compressed BOOLEAN NOT NULL, "
                        + "encrypted_message VARBINARY, encrypted_is_text BOOLEAN DEFAULT FALSE, "
                        + "is_encrypted BOOLEAN NOT NULL, timestamp INT NOT NULL, expiration INT NOT NULL, height INT NOT NULL, "
                        + "FOREIGN KEY (height) REFERENCES block (height) ON DELETE CASCADE)");
            case 287:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS prunable_message_id_idx ON prunable_message (id)");
            case 288:
                apply(null);
            case 289:
                apply("CREATE INDEX IF NOT EXISTS prunable_message_expiration_idx ON prunable_message (expiration DESC)");
            case 290:
                apply("ALTER TABLE transaction ADD COLUMN IF NOT EXISTS has_prunable_message BOOLEAN NOT NULL DEFAULT FALSE");
            case 291:
                apply("TRUNCATE TABLE unconfirmed_transaction");
            case 292:
                apply("ALTER TABLE unconfirmed_transaction ADD COLUMN IF NOT EXISTS prunable_json VARCHAR");
            case 293:
                apply("CREATE INDEX IF NOT EXISTS prunable_message_sender_idx ON prunable_message (sender_id)");
            case 294:
                apply("CREATE INDEX IF NOT EXISTS prunable_message_recipient_idx ON prunable_message (recipient_id)");
            case 295:
                apply(null);
            case 296:
                apply("ALTER TABLE transaction ADD COLUMN IF NOT EXISTS has_prunable_encrypted_message BOOLEAN NOT NULL DEFAULT FALSE");
            case 297:
                apply(null);
            case 298:
                apply("ALTER TABLE prunable_message ALTER COLUMN expiration RENAME TO transaction_timestamp");
            case 299:
                apply("UPDATE prunable_message SET transaction_timestamp = SELECT timestamp FROM transaction WHERE prunable_message.id = transaction.id");
            case 300:
                apply("ALTER INDEX prunable_message_expiration_idx RENAME TO prunable_message_transaction_timestamp_idx");
            case 301:
                apply("ALTER TABLE prunable_message ALTER COLUMN timestamp RENAME TO block_timestamp");
            case 302:
                apply("DROP INDEX IF EXISTS prunable_message_timestamp_idx");
            case 303:
                apply("CREATE INDEX IF NOT EXISTS prunable_message_block_timestamp_dbid_idx ON prunable_message (block_timestamp DESC, db_id DESC)");
            case 304:
                apply("DROP INDEX IF EXISTS prunable_message_height_idx");
            case 305:
                apply("DROP INDEX IF EXISTS public_key_height_idx");
            case 306:
                apply(null);
            case 307:
                apply(null);
            case 308:
                apply(null);
            case 309:
                apply(null);
            case 310:
                apply(null);
            case 311:
                apply(null);
            case 312:
                apply(null);

            case 313:
                apply(null);
            case 314:
                apply(null);
            case 315:
                apply(null);

            case 316:
                apply(null);
            case 317:
                apply(null);
            case 318:
                apply(null);
            case 319:
                apply(null);
            case 320:
                apply(null);
            case 321:
                apply(null);
            case 322:
                apply(null);
            case 323:
                apply("ALTER TABLE peer ADD COLUMN IF NOT EXISTS last_updated INT");
            case 324:
                apply("DROP INDEX IF EXISTS account_current_lessee_id_leasing_height_idx");
            case 325:
                apply("TRUNCATE TABLE account");
            case 326:
                apply("ALTER TABLE account ADD COLUMN IF NOT EXISTS active_lessee_id BIGINT");
            case 327:
                apply("ALTER TABLE account DROP COLUMN IF EXISTS current_leasing_height_from");
            case 328:
                apply("ALTER TABLE account DROP COLUMN IF EXISTS current_leasing_height_to");
            case 329:
                apply("ALTER TABLE account DROP COLUMN IF EXISTS current_lessee_id");
            case 330:
                apply("ALTER TABLE account DROP COLUMN IF EXISTS next_leasing_height_from");
            case 331:
                apply("ALTER TABLE account DROP COLUMN IF EXISTS next_leasing_height_to");
            case 332:
                apply("ALTER TABLE account DROP COLUMN IF EXISTS next_lessee_id");
            case 333:
                apply("CREATE INDEX IF NOT EXISTS account_active_lessee_id_idx ON account (active_lessee_id)");
            case 334:
                apply("CREATE TABLE IF NOT EXISTS account_lease (db_id IDENTITY, lessor_id BIGINT NOT NULL, "
                        + "current_leasing_height_from INT, current_leasing_height_to INT, current_lessee_id BIGINT, "
                        + "next_leasing_height_from INT, next_leasing_height_to INT, next_lessee_id BIGINT, "
                        + "height INT NOT NULL, latest BOOLEAN NOT NULL DEFAULT TRUE)");
            case 335:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS account_lease_lessor_id_height_idx ON account_lease (lessor_id, height DESC)");
            case 336:
                apply("CREATE INDEX IF NOT EXISTS account_lease_current_leasing_height_from_idx ON account_lease (current_leasing_height_from)");
            case 337:
                apply("CREATE INDEX IF NOT EXISTS account_lease_current_leasing_height_to_idx ON account_lease (current_leasing_height_to)");
            case 338:
                apply("CREATE INDEX IF NOT EXISTS account_lease_height_id_idx ON account_lease (height, lessor_id)");
            case 339:
                apply(null);
            case 340:
                apply(null);
            case 341:
                apply(null);
            case 342:
                apply("CREATE INDEX IF NOT EXISTS unconfirmed_transaction_expiration_idx ON unconfirmed_transaction (expiration DESC)");
            case 343:
                apply("DROP INDEX IF EXISTS account_height_idx");
            case 344:
                apply("CREATE INDEX IF NOT EXISTS account_height_id_idx ON account (height, id)");
            case 345:
                apply("DROP INDEX IF EXISTS account_asset_height_idx");
            case 346:
                apply(null);
            case 347:
                apply(null);
            case 348:
                apply(null);
            case 349:
                apply(null);
            case 350:
                apply(null);
            case 351:
                apply(null);
            case 352:
                apply(null);
            case 353:
                apply(null);
            case 354:
                apply(null);
            case 355:
                apply(null);
            case 356:
                apply(null);
            case 357:
                apply(null);
            case 358:
                apply(null);
            case 359:
                apply(null);
            case 360:
                apply(null);
            case 361:
                apply(null);
            case 362:
                apply(null);
            case 363:
                apply(null);
            case 364:
                apply(null);
            case 365:
                apply(null);
            case 366:
                apply(null);
            case 367:
                apply(null);
            case 368:
                apply(null);
            case 369:
                apply(null);
            case 370:
                apply(null);
            case 371:
                apply(null);
            case 372:
                apply(null);
            case 373:
                apply(null);
            case 374:
                apply(null);
            case 375:
                apply(null);
            case 376:
                apply(null);
            case 377:
                apply(null);
            case 378:
                apply(null);
            case 379:
                apply("DROP INDEX IF EXISTS account_info_height_idx");
            case 380:
                apply("CREATE INDEX IF NOT EXISTS account_info_height_id_idx ON account_info (height, account_id)");
            case 381:
                apply(null);
            case 382:
                apply(null);
            case 383:
                apply(null);
            case 384:
                apply(null);
            case 385:
                apply(null);
            case 386:
                apply(null);
            case 387:
                apply(null);

            case 388:
                apply(null);
            case 389:
                apply(null);
            case 390:
                apply(null);
            case 391:
                apply(null);
            case 392:
                apply(null);
            case 393:
                apply(null);
            case 394:
                apply("CREATE TABLE IF NOT EXISTS account_ledger (db_id IDENTITY, account_id BIGINT NOT NULL, "
                        + "event_type TINYINT NOT NULL, event_id BIGINT NOT NULL, holding_type TINYINT NOT NULL, "
                        + "holding_id BIGINT, change BIGINT NOT NULL, balance BIGINT NOT NULL, "
                        + "block_id BIGINT NOT NULL, height INT NOT NULL, timestamp INT NOT NULL)");
            case 395:
                apply("CREATE INDEX IF NOT EXISTS account_ledger_id_idx ON account_ledger(account_id, db_id)");
            case 396:
                apply("CREATE INDEX IF NOT EXISTS account_ledger_height_idx ON account_ledger(height)");
            case 397:
                apply("ALTER TABLE peer ADD COLUMN IF NOT EXISTS services BIGINT");
            case 398:
                apply(null);
            case 399:
                apply(null);
            case 400:
                apply(null);
            case 401:
                apply(null);
            case 402:
                apply(null);
            case 403:
                apply(null);

            case 404:
                apply(null);
            case 405:
                apply(null);
            case 406:
                apply("ALTER TABLE transaction ADD COLUMN IF NOT EXISTS has_prunable_attachment BOOLEAN NOT NULL DEFAULT FALSE");
            case 407:
                apply("UPDATE transaction SET has_prunable_attachment = TRUE WHERE type = 6");
            case 408:
                apply("TRUNCATE TABLE account");
            case 409:
                apply("ALTER TABLE account DROP COLUMN IF EXISTS creation_height");
            case 410:
                apply("ALTER TABLE account DROP COLUMN IF EXISTS key_height");
            case 411:
                apply("DROP INDEX IF EXISTS public_key_account_id_idx");
            case 412:
                apply("ALTER TABLE public_key ADD COLUMN IF NOT EXISTS latest BOOLEAN NOT NULL DEFAULT TRUE");
            case 413:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS public_key_account_id_height_idx ON public_key (account_id, height DESC)");
            case 414:
                apply(null);
            case 415:
                org.xel.db.FullTextTrigger.init();
                apply(null);
            case 416:
                apply(null);
            case 417:
                apply(null);
            case 418:
                apply(null);
            case 419:
                apply(null);
            case 420:
                apply(null);
            case 421:
                apply("TRUNCATE TABLE account_ledger");
            case 422:
                apply(null);
            case 423:
                apply(null);
            case 424:
                apply(null);
            case 425:
                apply(null);
            case 426:
                apply(null);
            case 427:
                apply(null);
            case 428:
                apply(null);
            case 429:
                apply(null);
            case 430:
                apply(null);
            case 431:
                apply(null);
            case 432:
                apply(null);
            case 433:
                apply("CREATE TABLE IF NOT EXISTS phasing_poll_linked_transaction (db_id IDENTITY, "
                        + "transaction_id BIGINT NOT NULL, linked_full_hash BINARY(32) NOT NULL, linked_transaction_id BIGINT NOT NULL, "
                        + "height INT NOT NULL)");
            case 434:
                apply(null);
            case 435:
                apply("CREATE INDEX IF NOT EXISTS phasing_poll_linked_transaction_height_idx ON phasing_poll_linked_transaction (height)");
            case 436:
                apply(null);
            case 437:
                apply("ALTER TABLE phasing_poll DROP COLUMN IF EXISTS linked_full_hashes");
            case 438:
                apply("CREATE TABLE IF NOT EXISTS account_control_phasing (db_id IDENTITY, account_id BIGINT NOT NULL, "
                        + "whitelist ARRAY, voting_model TINYINT NOT NULL, quorum BIGINT, min_balance BIGINT, "
                        + "holding_id BIGINT, min_balance_model TINYINT, max_fees BIGINT, min_duration SMALLINT, max_duration SMALLINT, "
                        + "height INT NOT NULL, latest BOOLEAN NOT NULL DEFAULT TRUE)");
            case 439:
                apply("ALTER TABLE account ADD COLUMN IF NOT EXISTS has_control_phasing BOOLEAN NOT NULL DEFAULT FALSE");
            case 440:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS account_control_phasing_id_height_idx ON account_control_phasing (account_id, height DESC)");
            case 441:
                apply("CREATE INDEX IF NOT EXISTS account_control_phasing_height_id_idx ON account_control_phasing (height, account_id)");
            case 442:
                apply("CREATE TABLE IF NOT EXISTS account_property (db_id IDENTITY, id BIGINT NOT NULL, account_id BIGINT NOT NULL, setter_id BIGINT, "
                        + "property VARCHAR NOT NULL, value VARCHAR, height INT NOT NULL, latest BOOLEAN NOT NULL DEFAULT TRUE)");
            case 443:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS account_property_id_height_idx ON account_property (id, height DESC)");
            case 444:
                apply("CREATE INDEX IF NOT EXISTS account_property_height_id_idx ON account_property (height, id)");
            case 445:
                apply("CREATE INDEX IF NOT EXISTS account_property_account_height_idx ON account_property (account_id, height DESC)");
            case 446:
                apply("CREATE INDEX IF NOT EXISTS account_property_setter_account_idx ON account_property (setter_id, account_id)");
            case 447:
                apply(null);
            case 448:
                apply(null);
            case 449:
                apply(null);
            case 450:
                apply(null);
            case 451:
                apply(null);
            case 452:
                apply("ALTER TABLE prunable_message ADD COLUMN IF NOT EXISTS encrypted_message VARBINARY");
            case 453:
                apply("ALTER TABLE prunable_message ADD COLUMN IF NOT EXISTS encrypted_is_text BOOLEAN DEFAULT FALSE");
            case 454:
                apply("UPDATE prunable_message SET encrypted_message = message WHERE is_encrypted IS TRUE");
            case 455:
                apply("ALTER TABLE prunable_message ALTER COLUMN message SET NULL");
            case 456:
                apply("UPDATE prunable_message SET message = NULL WHERE is_encrypted IS TRUE");
            case 457:
                apply("UPDATE prunable_message SET encrypted_is_text = TRUE WHERE is_encrypted IS TRUE AND is_text IS TRUE");
            case 458:
                apply("UPDATE prunable_message SET encrypted_is_text = FALSE WHERE is_encrypted IS TRUE AND is_text IS FALSE");
            case 459:
                apply("UPDATE prunable_message SET is_text = FALSE where is_encrypted IS TRUE");
            case 460:
                apply("ALTER TABLE prunable_message ALTER COLUMN is_text RENAME TO message_is_text");
            case 461:
                apply("ALTER TABLE prunable_message DROP COLUMN IF EXISTS is_encrypted");
            case 462:
                apply(null);
            case 463:
                apply(null);
            case 464:
                apply(null);
            case 465:
                apply(null);
            case 466:
                apply("ALTER TABLE account_property ALTER COLUMN account_id RENAME TO recipient_id");
            case 467:
                apply("ALTER INDEX account_property_account_height_idx RENAME TO account_property_recipient_height_idx");
            case 468:
                apply("ALTER INDEX account_property_setter_account_idx RENAME TO account_property_setter_recipient_idx");
            case 469:
                apply(null);
            case 470:
                apply("CREATE TABLE IF NOT EXISTS referenced_transaction (db_id IDENTITY, transaction_id BIGINT NOT NULL, "
                        + "FOREIGN KEY (transaction_id) REFERENCES transaction (id) ON DELETE CASCADE, "
                        + "referenced_transaction_id BIGINT NOT NULL)");
            case 471:
                try (Connection con = db.getConnection();
                     PreparedStatement pstmt = con.prepareStatement(
                             "SELECT id, referenced_transaction_full_hash FROM transaction WHERE referenced_transaction_full_hash IS NOT NULL");
                     PreparedStatement pstmtInsert = con.prepareStatement(
                             "INSERT INTO referenced_transaction (transaction_id, referenced_transaction_id) VALUES (?, ?)");
                     ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        pstmtInsert.setLong(1, rs.getLong("id"));
                        pstmtInsert.setLong(2, Convert.fullHashToId(rs.getBytes("referenced_transaction_full_hash")));
                        pstmtInsert.executeUpdate();
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e.toString(), e);
                }
                apply(null);
            case 472:
                apply("CREATE INDEX IF NOT EXISTS referenced_transaction_referenced_transaction_id_idx ON referenced_transaction (referenced_transaction_id)");
            case 473:
                BlockDb.deleteBlocksFromHeight(Constants.SHUFFLING_BLOCK);
                BlockchainProcessorImpl.getInstance().scheduleScan(0, false);
                apply(null);
            case 474:
                apply("DROP INDEX IF EXISTS phasing_poll_linked_transaction_id_link_idx");
            case 475:
                apply("CREATE " + (Constants.isTestnet ? "" : "UNIQUE ") + "INDEX IF NOT EXISTS phasing_poll_linked_transaction_id_link_idx "
                        + "ON phasing_poll_linked_transaction (transaction_id, linked_transaction_id)");
            case 476:
                apply("DROP INDEX IF EXISTS phasing_poll_linked_transaction_link_id_idx");
            case 477:
                apply("CREATE " + (Constants.isTestnet ? "" : "UNIQUE ") + "INDEX IF NOT EXISTS phasing_poll_linked_transaction_link_id_idx "
                        + "ON phasing_poll_linked_transaction (linked_transaction_id, transaction_id)");
            case 478:
                try (Connection con = db.getConnection();
                     Statement stmt = con.createStatement();
                     ResultSet rs = stmt.executeQuery("SELECT CONSTRAINT_NAME FROM INFORMATION_SCHEMA.CONSTRAINTS "
                             + "WHERE TABLE_NAME='BLOCK' AND (COLUMN_LIST='NEXT_BLOCK_ID' OR COLUMN_LIST='PREVIOUS_BLOCK_ID')")) {
                    List<String> constraintNames = new ArrayList<>();
                    while (rs.next()) {
                        constraintNames.add(rs.getString(1));
                    }
                    for (String constraintName : constraintNames) {
                        stmt.executeUpdate("ALTER TABLE BLOCK DROP CONSTRAINT " + constraintName);
                    }
                    apply(null);
                } catch (SQLException e) {
                    throw new RuntimeException(e.toString(), e);
                }
            case 479:
                apply(null);
            case 480:
                apply(null);
            case 481:
                apply(null);
            case 482:
                apply(null);
            case 483:
                apply(null);
            case 484:
                apply(null);
            case 485:
                BlockDb.deleteBlocksFromHeight(Constants.FXT_BLOCK);
                apply(null);
            case 486:
                apply(null);

            case 487:
                apply(null);
            case 488:
                apply(null);
            case 489:
                apply(null);
                // Here, the work related stuff begins
            case 490:
                apply("CREATE TABLE IF NOT EXISTS work (db_id IDENTITY, cap_number_pow INT NOT NULL, " +
                        "closing_timestamp " +
                        "INT " +
                        "NOT NULL, id BIGINT NOT NULL, block_id BIGINT NOT NULL, sender_account_id BIGINT NOT NULL, xel_per_pow BIGINT NOT NULL, iterations SMALLINT NOT NULL, iterations_left SMALLINT NOT NULL, blocks_remaining SMALLINT NOT NULL, closed BOOLEAN NOT NULL DEFAULT FALSE, cancelled BOOLEAN NOT NULL DEFAULT FALSE, timedout BOOLEAN NOT NULL DEFAULT FALSE, xel_per_bounty BIGINT NOT NULL, received_bounties INT NOT NULL, received_pows INT NOT NULL, bounty_limit_per_iteration INT NOT NULL, originating_height INT NOT NULL, storage_size INT NOT NULL, source_code CLOB NOT NULL, height INT NOT NULL, latest BOOLEAN NOT NULL DEFAULT TRUE)");
            case 491:
                apply("CREATE INDEX IF NOT EXISTS workA ON work (id)");
            case 492:
                apply("CREATE INDEX IF NOT EXISTS workC ON work (sender_account_id)");
            case 493:
                apply("CREATE INDEX IF NOT EXISTS workD ON work (closed)");
            case 494:
                apply(
                        "CREATE TABLE IF NOT EXISTS pow_and_bounty (db_id IDENTITY, id BIGINT NOT NULL,too_late " +
                                "BOOLEAN NOT NULL DEFAULT FALSE, work_id BIGINT NOT NULL, hash BINARY(32), multiplier" +
                                " VARBINARY, storage_bucket INT, submitted_storage VARBINARY, account_id BIGINT NOT NULL, " +
                                "is_pow BOOLEAN NOT NULL DEFAULT TRUE, verificator_hash BINARY(32), pow_hash BINARY" +
                                "(32), was_paid BOOLEAN NOT NULL DEFAULT FALSE, publickey VARBINARY NOT NULL, timestamp " +
                                "INT NOT NULL, " +
                                " " +
                                "height " +
                                "INT NOT NULL," +
                                " latest " +
                                "BOOLEAN NOT " +
                                "NULL DEFAULT TRUE)");
            case 495:
                apply("CREATE INDEX IF NOT EXISTS pow_and_bountyA ON pow_and_bounty (id)");
            case 496:
                apply("CREATE INDEX IF NOT EXISTS pow_and_bountyB ON pow_and_bounty (work_id)");
            case 497:
                apply("CREATE INDEX IF NOT EXISTS pow_and_bountyC ON pow_and_bounty (is_pow)");
            case 498:
                apply("CREATE INDEX IF NOT EXISTS pow_and_bountyD ON pow_and_bounty (height)");
            case 499:
                apply("CREATE TABLE IF NOT EXISTS block_comp (db_id IDENTITY, id BIGINT NOT NULL, version INT NOT NULL, "
                        + "timestamp INT NOT NULL, previous_block_id BIGINT, "
                        + "total_amount BIGINT NOT NULL, "
                        + "total_fee BIGINT NOT NULL, payload_length INT NOT NULL, "
                        + "previous_block_hash BINARY(32), cumulative_difficulty VARBINARY NOT NULL, base_target " +
                        "BIGINT NOT NULL, pow_target BIGINT, pow_last_mass INT, pow_mass INT, target_last_mass BIGINT, target_mass BIGINT, " +
                        "next_block_id BIGINT, "
                        + "height INT NOT NULL, generation_signature BINARY(64) NOT NULL, "
                        + "block_signature BINARY(64) NOT NULL, payload_hash BINARY(32) NOT NULL, generator_id BIGINT NOT NULL)");
            case 500:
                apply("CREATE TABLE IF NOT EXISTS transaction_comp (db_id IDENTITY, id BIGINT NOT NULL, "
                        + "deadline SMALLINT NOT NULL, recipient_id BIGINT, "
                        + "amount BIGINT NOT NULL, fee BIGINT NOT NULL, full_hash BINARY(32) NOT NULL, "
                        + "height INT NOT NULL, block_id BIGINT NOT NULL, FOREIGN KEY (block_id) REFERENCES block_comp (id) ON DELETE CASCADE, "
                        + "signature BINARY(64) NOT NULL, timestamp INT NOT NULL, type TINYINT NOT NULL, subtype TINYINT NOT NULL, "
                        + "sender_id BIGINT NOT NULL, block_timestamp INT NOT NULL, referenced_transaction_full_hash BINARY(32), "
                        + "transaction_index SMALLINT NOT NULL, phased BOOLEAN NOT NULL DEFAULT FALSE, "
                        + "attachment_bytes VARBINARY, version TINYINT NOT NULL, has_message BOOLEAN NOT NULL DEFAULT FALSE, "
                        + "has_encrypted_message BOOLEAN NOT NULL DEFAULT FALSE, has_public_key_announcement BOOLEAN NOT NULL DEFAULT FALSE, "
                        + "has_prunable_message BOOLEAN NOT NULL DEFAULT FALSE, has_prunable_attachment BOOLEAN NOT NULL DEFAULT FALSE, "
                        + "ec_block_height INT DEFAULT NULL, ec_block_id BIGINT DEFAULT NULL, has_encrypttoself_message BOOLEAN NOT NULL DEFAULT FALSE,has_prunable_encrypted_message BOOLEAN NOT NULL DEFAULT FALSE)");
            case 501:
                apply("CREATE TABLE IF NOT EXISTS unconfirmed_transaction_comp (db_id IDENTITY, id BIGINT NOT NULL, expiration INT NOT NULL, "
                        + "transaction_height INT NOT NULL, fee_per_byte BIGINT NOT NULL, arrival_timestamp BIGINT NOT NULL, "
                        + "transaction_bytes VARBINARY NOT NULL, height INT NOT NULL, prunable_json VARCHAR)");
            case 502:
                apply("CREATE TABLE IF NOT EXISTS referenced_transaction_comp (db_id IDENTITY, transaction_id BIGINT NOT NULL, "
                        + "FOREIGN KEY (transaction_id) REFERENCES transaction_comp (id) ON DELETE CASCADE, "
                        + "referenced_transaction_id BIGINT NOT NULL)");

            case 503:
                apply("CREATE INDEX IF NOT EXISTS comp_transaction_sender_id_idx ON transaction_comp (sender_id)");
            case 504:
                apply("CREATE INDEX IF NOT EXISTS comp_transaction_recipient_id_idx ON transaction_comp (recipient_id)");
            case 505:
                apply("CREATE INDEX IF NOT EXISTS comp_transaction_block_timestamp_idx ON transaction_comp (block_timestamp DESC)");
            case 506:
                apply("CREATE INDEX IF NOT EXISTS comp_unconfirmed_transaction_height_fee_timestamp_idx ON unconfirmed_transaction_comp "
                        + "(transaction_height ASC, fee_per_byte DESC, arrival_timestamp ASC)");
            case 507:
                apply("CREATE INDEX IF NOT EXISTS comp_unconfirmed_transaction_expiration_idx ON unconfirmed_transaction_comp (expiration DESC)");
            case 508:
                apply("CREATE INDEX IF NOT EXISTS comp_referenced_transaction_referenced_transaction_id_idx ON referenced_transaction_comp (referenced_transaction_id)");
            case 509:
                apply("CREATE INDEX IF NOT EXISTS comp_block_generator_id_idx ON block_comp (generator_id)");
            case 510:
                apply("CREATE INDEX IF NOT EXISTS comp_transaction_block_timestamp_idx ON transaction_comp (block_timestamp DESC)");
            case 511:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS comp_block_id_idx ON block_comp (id)");
            case 512:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS comp_block_height_idx ON block_comp (height)");
            case 513:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS comp_block_timestamp_idx ON block_comp (timestamp DESC)");
            case 514:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS comp_transaction_id_idx ON transaction_comp (id)");
            case 515:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS comp_unconfirmed_transaction_id_idx ON unconfirmed_transaction_comp (id)");
            case 516:
                apply("CREATE TABLE IF NOT EXISTS scan_comp (rescan BOOLEAN NOT NULL DEFAULT FALSE, height INT NOT NULL DEFAULT 0, "
                        + "validate BOOLEAN NOT NULL DEFAULT FALSE)");
            case 517:
                apply("INSERT INTO scan_comp (rescan, height, validate) VALUES (false, 0, false)");
            case 518:
            case 519:
                apply("CREATE TABLE IF NOT EXISTS acp (db_id IDENTITY, id BIGINT NOT NULL, publickey VARBINARY)");
            case 520:
                apply("CREATE UNIQUE INDEX IF NOT EXISTS acp_idx ON acp (id)");
            case 521:
                return;
            default:
                throw new RuntimeException("Blockchain database inconsistent with code, at update " + nextUpdate
                        + ", probably trying to run older code on newer database");
        }
    }
}
